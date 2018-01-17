
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.1.4-3"
    id("cn.bestwu.kotlin-publish") version "0.0.15"
}

group = "cn.bestwu"
version = "0.0.2-SNAPSHOT"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-reflect:1.1.4-3")
    compile ("org.pegdown:pegdown:1.6.0")

    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
}