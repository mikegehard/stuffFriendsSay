plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.0"
    defaultConfig {
        applicationId = "io.github.mikegehard.stufffriendssay.android"
        minSdkVersion(27)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
           isMinifyEnabled = false
           proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }

}

dependencies {
    implementation(project(":components:messages"))
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:${Versions.androidx}")
    // Need this to prevent the missing class error for missing androidx.constraintlayout.widget.R$styleable class
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha4")
    implementation("androidx.core:core-ktx:1.2.0")
    testImplementation("junit:junit:4.12")
}
