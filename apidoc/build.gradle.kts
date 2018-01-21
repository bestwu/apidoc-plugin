
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.2.20"
    id("cn.bestwu.kotlin-publish") version "0.0.17"
}

group = "cn.bestwu"
version = "0.0.2-SNAPSHOT"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-reflect:1.2.10")
    compile ("org.pegdown:pegdown:1.6.0")
    compile("com.beust:klaxon:0.32")

    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
}