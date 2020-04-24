import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:${Versions.shadowjar}")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:${Versions.bintrayPlugin}")
    }
}

plugins {
    id("kotlin")
    id("application")
    id("com.palantir.git-version") version "0.12.2"
    id("com.github.johnrengelman.shadow") version Versions.shadowjar
    id("com.jfrog.bintray") version Versions.bintrayPlugin
}

group = "dev.rubbersidedowntech"

val gitVersion: groovy.lang.Closure<*> by extra
version = gitVersion()

sourceSets {
    main {
        resources.srcDir("resources")
        java.srcDir("src")
    }

    test {
        java.srcDir("test")
    }
}

repositories {
    mavenLocal()
    jcenter()
    maven {
        url = uri("https://kotlin.bintray.com/ktor")
    }
}

dependencies {
    implementation(project(":components:messages"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("ch.qos.logback:logback-classic:${Versions.logback}")
    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-host-common:${Versions.ktor}")
    implementation("io.ktor:ktor-jackson:${Versions.ktor}")
    implementation("io.ktor:ktor-html-builder:${Versions.ktor}")
    testImplementation("io.ktor:ktor-server-tests:${Versions.ktor}")
}

val foo = "io.ktor.server.netty.EngineMain"

application {
    mainClassName = foo
}

tasks {
    named<ShadowJar>("shadowJar") {
        manifest {
            attributes(mapOf("Main-Class" to foo))
        }
    }
}

//shadowJar {
//    manifest {
//        attributes = "Main-Class:$mainClassName"
//    }
//}

tasks.test {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
    }
}
