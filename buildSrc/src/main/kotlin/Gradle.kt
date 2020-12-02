@Suppress("unused")
object Versions {
    const val kotlin = "1.3.71"
    const val android_gradle_plugin = "3.5.0"

    const val compile_sdk_version = 29
    const val build_tools_version = "29.0.2"
    const val min_sdk_version = 23
    const val target_sdk_version = 29

    // Google libs
    const val google_service_plugin = "4.3.3"

    const val appcompat = "1.1.0" // x
    const val recyclerview = "1.1.0" // x
    const val material = "1.1.0" // x
    const val security_crypto = "1.0.0-rc01"
    const val room = "2.2.5"
    const val swiperefreshlayout = "1.1.0-rc01"
    const val constraint_layout = "2.0.1"
    const val navigation = "2.3.0-alpha05"
    const val firebase_analytics = "17.4.0"
    const val play_services_location = "17.0.0"
    const val firebase_crashlytics_plugin = "2.1.0"
    const val firebase_appdistribution_plugin = "1.4.1"
    const val firebase_crashlytics = "17.0.0"
    const val firebase_messaging = "20.1.6"
    const val fragment = "1.3.0-alpha06"

    // Other
    const val retrofit = "2.8.1"
    const val okhttp_logging_interceptor = "4.6.0"
    const val koin = "2.1.5"
    const val junit = "4.13"
    const val mockito = "3.3.3" // x
    const val mockito_kotlin = "2.2.0"
    const val mockwebserver = "4.5.0"
    const val glide = "4.11.0"
    const val ktlint = "0.36.0"
    const val detekt = "1.3.0"
    const val coroutines = "1.3.5"
    const val arch_core_testing = "2.1.0"
    const val material_calendarview = "2.0.1"
    const val threetenabp = "1.1.1"
    const val oss_licenses_plugin = "0.10.2"
    const val play_services_oss_licenses = "17.0.0"
    const val permissions_dispatcher = "4.7.0"
    const val permissions_dispatcher_ktx = "1.0.0-alpha2"
    const val lottieVersion = "3.4.1"
}

object ClassPaths {
    const val android_gradle_plugin =
        "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigation_safeargs_plugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val google_service_plugin =
        "com.google.gms:google-services:${Versions.google_service_plugin}"
    const val firebase_crashlytics_plugin =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebase_crashlytics_plugin}"
    const val firebase_appdistribution_plugin =
        "com.google.firebase:firebase-appdistribution-gradle:${Versions.firebase_appdistribution_plugin}"
    const val oss_licenses_plugin =
        "com.google.android.gms:oss-licenses-plugin:${Versions.oss_licenses_plugin}"
}

object Plugins {
    const val androidApp = "com.android.application"
    const val kotlin = "kotlin"
    const val javalib = "java-library"
    const val androidLib = "com.android.library"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val googleServices = "com.google.gms.google-services"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val firebase_crashlytics = "com.google.firebase.crashlytics"
    const val firebase_appdistribution = "com.google.firebase.appdistribution"
    const val ossLicenses = "com.google.android.gms.oss-licenses-plugin"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val security_crypto = "androidx.security:security-crypto:${Versions.security_crypto}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_testing = "androidx.room:room-testing:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val navigation_fragment_ktx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val firebase_analytics =
        "com.google.firebase:firebase-analytics:${Versions.firebase_analytics}"
    const val play_services_location =
        "com.google.android.gms:play-services-location:${Versions.play_services_location}"
    const val firebase_crashlytics =
        "com.google.firebase:firebase-crashlytics:${Versions.firebase_crashlytics}"
    const val firebase_messaging =
        "com.google.firebase:firebase-messaging:${Versions.firebase_messaging}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"
    const val glide_runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_test =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    const val junit = "junit:junit:${Versions.junit}"
    const val mockito_kotlin =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"

    const val koin_android = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koin_ext = "org.koin:koin-androidx-ext:${Versions.koin}"
    const val koin_test = "org.koin:koin-test:${Versions.koin}"

    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mock_web_server = "com.squareup.okhttp3:mockwebserver:${Versions.mockwebserver}"

    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
    const val arch_core_testing = "androidx.arch.core:core-testing:${Versions.arch_core_testing}"
    const val material_calendarview =
        "com.github.prolificinteractive:material-calendarview:${Versions.material_calendarview}"
    const val threetenabp = "com.jakewharton.threetenabp:threetenabp:${Versions.threetenabp}"

    const val play_services_oss_licenses =
        "com.google.android.gms:play-services-oss-licenses:${Versions.play_services_oss_licenses}"
    const val permissions_dispatcher =
        "org.permissionsdispatcher:permissionsdispatcher:${Versions.permissions_dispatcher}"
    const val permissions_dispatcher_ktx =
        "org.permissionsdispatcher:permissionsdispatcher-ktx:${Versions.permissions_dispatcher_ktx}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
}
