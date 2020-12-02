import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.util.*
import java.util.regex.Pattern

plugins {
    id(Plugins.androidApp)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExt)
    kotlin(Plugins.kotlinApt)
    id(Plugins.navigationSafeArgs)
    id(Plugins.detekt).version(Versions.detekt)
    id(Plugins.firebase_crashlytics)
    id(Plugins.firebase_appdistribution)
    id(Plugins.googleServices)
}

buildscript {
    apply(from = "autodimension.gradle.kts")
    apply(from = "../ktlint.gradle.kts")
    apply(from = "../distribution.gradle.kts")
}

val versionCode = 1
val versionName = "1.0.0"

fun buildVersionCode() = versionCode

fun buildVersionName(): String {
    return if (getCurrentFlavor() != "production") {
        versionName.plus(" - ${getLatestCommitHash()}")
    } else versionName
}

fun getCurrentFlavor(): String {
    val task = gradle.startParameter.taskRequests.toString()
    val pattern = if (task.contains("assemble"))
        Pattern.compile("assemble(\\w+)(Release|Debug)")
    else
        Pattern.compile("generate(\\w+)(Release|Debug)")
    val matcher = pattern.matcher(task)

    return if (matcher.find()) {
        matcher.group(1).toLowerCase()
    } else {
        ""
    }
}

/**
 * To get the latest short git commit hash.
 */
fun getLatestCommitHash(): String {
    val stdout = ByteArrayOutputStream()
    try {
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
    } catch (ignored: Exception) {
    }
    return stdout.toString().replace("\n", "")
}

// Load signing configs for release
val keystorePropertiesFile = rootProject.file("distribution/keystore.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    compileSdkVersion(Versions.compile_sdk_version)
    buildToolsVersion(Versions.build_tools_version)

    defaultConfig {
        applicationId = "namnh.clean.sample"
        minSdkVersion(Versions.min_sdk_version)
        targetSdkVersion(Versions.target_sdk_version)
        versionCode = buildVersionCode()
        versionName = buildVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles(
            file("proguard-rules.pro")
        )
    }

    signingConfigs {
        create("release") {
            storeFile = file(keystoreProperties["storeFile"] as Any)
            storePassword = keystoreProperties["storePassword"] as? String
            keyAlias = keystoreProperties["keyAlias"] as? String
            keyPassword = keystoreProperties["keyPassword"] as? String
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                file("proguard-rules.pro")
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    flavorDimensions("default")
    productFlavors {
        create("develop") {
            applicationIdSuffix = ".dev"
            manifestPlaceholders = mapOf("applicationName" to "@string/app_name_dev")
            firebaseAppDistribution {
                releaseNotesFile = "app/src/develop/release_notes.txt"
                groups = ""
            }
        }

        create("staging") {
            applicationIdSuffix = ".stg"
            manifestPlaceholders = mapOf("applicationName" to "@string/app_name_staging")
            firebaseAppDistribution {
                releaseNotesFile = "app/src/develop/release_notes.txt"
                groups = ""
            }
        }

        create("production") {
            manifestPlaceholders = mapOf("applicationName" to "@string/app_name")
            firebaseAppDistribution {
                releaseNotesFile = "app/src/develop/release_notes.txt"
                groups = ""
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dataBinding {
        isEnabled = true
    }
}

androidExtensions {
    isExperimental = true
}

detekt {
    config = files("$rootDir/config/detekt/detekt.yml")
    input = files("src/main/java")
    reports {
        html.enabled = true // observe findings in your browser with structure and code snippets
        xml.enabled = false // checkstyle like format mainly for integrations like Jenkins
        txt.enabled = false // similar to the console output, contains issue signature to manually edit baseline files
    }
    // use default reports, see at app/build/reports/detekt
}

tasks {
    clean {
        dependsOn("createDimen")
        mustRunAfter("createDimen")
    }
    check {
        dependsOn("ktlintCheck")
        dependsOn("ktlintFormat")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":shared"))
    implementation(Deps.kotlin_stdlib)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    implementation(Deps.constraint_layout)
    implementation(Deps.recyclerview)
    implementation(Deps.swiperefreshlayout)
    implementation(Deps.security_crypto)
    implementation(Deps.firebase_analytics)
    implementation(Deps.firebase_crashlytics)
    implementation(Deps.firebase_messaging)

    implementation(Deps.fragment)
    implementation(Deps.fragment_ktx)

    implementation(Deps.navigation_fragment_ktx)
    implementation(Deps.navigation_ui_ktx)

    implementation(Deps.koin_android)
    implementation(Deps.koin_viewmodel)
    implementation(Deps.koin_ext)
    implementation(Deps.koin_test)

    kapt(Deps.glide_compiler)
    implementation(Deps.glide_runtime)

    kapt(Deps.room_compiler)
    implementation(Deps.room_runtime)
    implementation(Deps.room_testing)
    implementation(Deps.room_ktx)

    implementation(Deps.retrofit_runtime)
    implementation(Deps.retrofit_gson)
    implementation(Deps.okhttp_logging_interceptor)
    implementation(Deps.material_calendarview) {
        exclude(group = "com.jakewharton.threetenabp", module = "threetenabp")
    }
    implementation(Deps.threetenabp)

    implementation(Deps.coroutines_android)
    implementation(Deps.coroutines_core)
    implementation(Deps.coroutines_test)

    implementation(Deps.play_services_oss_licenses)
    implementation(Deps.permissions_dispatcher)
    implementation(Deps.permissions_dispatcher_ktx)

    implementation(Deps.lottie)

    testImplementation(Deps.junit)
    testImplementation(Deps.mockito_core)
    testImplementation(Deps.mockito_inline)
    testImplementation(Deps.mockito_kotlin)
    testImplementation(Deps.mock_web_server)
    testImplementation(Deps.arch_core_testing)
}
apply(plugin = Plugins.googleServices)
apply(plugin = Plugins.ossLicenses)
