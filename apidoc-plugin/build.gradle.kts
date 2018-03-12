import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.2.30"
    id("cn.bestwu.plugin-publish") version "0.0.18"
}

group = "cn.bestwu.gradle"
version = "1.2.9"

dependencies {
    compile(gradleApi())
    compile(project(":apidoc"))
}
