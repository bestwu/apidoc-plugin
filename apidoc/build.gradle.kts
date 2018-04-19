
import org.gradle.kotlin.dsl.*
import org.jetbrains.dokka.gradle.DokkaTask

val kotlinVersion = "1.2.30"


plugins {
    kotlin("jvm") version "1.2.30"
    id("cn.bestwu.kotlin-publish") version "0.0.19"
}

group = "cn.bestwu"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile ("org.pegdown:pegdown:1.6.0")
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.4")

    testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks{
    "dokkaJavadoc"(DokkaTask::class) {
        noStdlibLink = true
    }
}