import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("co.touchlab.native.cocoapods")
}

kotlin {
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
        summary = "Goodbyes library for Stuff Friends Say"
        homepage = "https://github.com/mikegehard/stuffFriendsSay"
        framework {
            isStatic = false
        }
    }

    sourceSets["commonMain"].dependencies {
        implementation(project(":components:platforms"))
        implementation(kotlin("stdlib", Versions.kotlin))
    }
}
