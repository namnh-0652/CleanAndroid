plugins {
    id(Plugins.androidLib)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExt)
    id(Plugins.detekt).version(Versions.detekt)
}

buildscript {
    apply(from = "../ktlint.gradle.kts")
}

tasks {
    check {
        dependsOn("ktlintCheck")
        dependsOn("ktlintFormat")
    }
}

android {
    compileSdkVersion(Versions.compile_sdk_version)
    buildToolsVersion(Versions.build_tools_version)

    defaultConfig {
        minSdkVersion(Versions.min_sdk_version)
        targetSdkVersion(Versions.target_sdk_version)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles(
            file("proguard-rules.pro")
        )
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                file("proguard-rules.pro")
            )
        }
    }

}

dependencies {
    implementation(Deps.kotlin_stdlib)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    implementation(Deps.recyclerview)

    testImplementation(Deps.junit)
}
