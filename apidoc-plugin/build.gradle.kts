import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.1.4-3"
    id("cn.bestwu.plugin-publish") version "0.0.15"
//    id("com.jfrog.artifactory") version "4.5.2"
}

group = "cn.bestwu.gradle"
version = "1.2.5"

dependencies {
    compile(gradleApi())
    compile(project(":apidoc"))
}
