import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*

plugins {
    idea
    kotlin("jvm") version "1.2.21"
    kotlin("plugin.spring") version "1.2.21"
    id("org.springframework.boot") version "1.5.9.RELEASE"
    id("cn.bestwu.kotlin-publish") version "0.0.17"
}

group = "cn.bestwu"
version = "0.0.3"


dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.2.21")

    //web
    compile("org.springframework.boot:spring-boot-starter-web")

    //util
    compile("cn.bestwu:common-lang:1.0.7")

    compile("cn.bestwu:generator:0.0.4")
    compile(project(":apidoc"))

    compileOnly("org.springframework.boot:spring-boot-configuration-processor")

    //test
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("mysql:mysql-connector-java:5.1.45")
    testCompile("cn.bestwu:test:1.1")
}
tasks {
    "compileJava" {
        dependsOn("processResources")
    }
}
idea {
    module {

        outputDir = java.sourceSets["main"].java.outputDir
        testOutputDir = java.sourceSets["test"].java.outputDir

        inheritOutputDirs = false

        isDownloadJavadoc = false
        isDownloadSources = true
    }
}