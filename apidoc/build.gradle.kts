
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.1.4-3"
    id("cn.bestwu.kotlin-publish") version "0.0.6"
}

group = "cn.bestwu"
version = "0.0.1"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-reflect:1.1.4-3")
    compile("com.beust:klaxon:0.31")
    compile ("org.pegdown:pegdown:1.6.0")

    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
}

publish {
    projectUrl = "https://bitbucket.org/betterwu/apidoc-plugin"
    vcsUrl = "https://bestwu@bitbucket.org/betterwu/apidoc-plugin.git"
}