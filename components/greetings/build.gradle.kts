import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()

    version = "1.0"

    sourceSets["commonMain"].dependencies {
        implementation(project(":components:platforms"))
        implementation(kotlin("stdlib", Versions.kotlin))
    }
}
