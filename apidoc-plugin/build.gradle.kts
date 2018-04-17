import org.gradle.kotlin.dsl.*
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm") version "1.2.30"
    id("cn.bestwu.plugin-publish") version "0.0.19"
}

group = "cn.bestwu.gradle"
version = "1.2.10"

dependencies {
    compile(gradleApi())
    compile(project(":apidoc"))
}

tasks{
    "dokkaJavadoc"(DokkaTask::class) {
        noStdlibLink = true
    }
}