import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.2.21"
    id("cn.bestwu.plugin-publish") version "0.0.17"
}

group = "cn.bestwu.gradle"
version = "1.2.5-SNAPSHOT"

dependencies {
    compile(gradleApi())
    compile(project(":apidoc"))
}
