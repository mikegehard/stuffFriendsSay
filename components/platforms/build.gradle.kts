import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    // Need this to get frameworks to build
//    kotlin("native.cocoapods")
    id("co.touchlab.native.cocoapods")
    id("com.android.library")
//    id("co.touchlab.kotlinxcodesync")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    android()
    jvm()
    //Revert to just ios() when gradle plugin can properly resolve it
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }
    targets.getByName<KotlinNativeTarget>("ios").compilations["main"].kotlinOptions.freeCompilerArgs += "-Xobjc-generics"

    version = "1.0"

    cocoapodsext {
        summary = "Platforms library for Stuff Friends Say"
        homepage = "https://github.com/mikegehard/stuffFriendsSay"
        framework {
//            isStatic = false
        }
    }

    sourceSets["commonMain"].dependencies {
        implementation(kotlin("stdlib-common", Versions.kotlin))
    }

    sourceSets["androidMain"].dependencies {
        implementation(kotlin("stdlib", Versions.kotlin))
    }

    sourceSets["jvmMain"].dependencies {
        implementation(kotlin("stdlib", Versions.kotlin))
    }
}
