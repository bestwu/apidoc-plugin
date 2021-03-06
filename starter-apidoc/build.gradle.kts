import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*
import org.jetbrains.dokka.gradle.DokkaTask

val kotlinVersion = "1.2.30"

plugins {
    idea
    kotlin("jvm") version "1.2.30"
    kotlin("plugin.spring") version "1.2.30"
    id("org.springframework.boot") version "2.0.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
    id("cn.bestwu.kotlin-publish") version "0.0.19"
}

group = "cn.bestwu"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    //web
    compile("org.springframework.boot:spring-boot-starter-web")

    //util
    compile("cn.bestwu:common-lang:1.1.0")

    compile("cn.bestwu:generator:0.0.5")
    compile(project(":apidoc"))

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")

    //test
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("mysql:mysql-connector-java:5.1.45")
}
tasks {
    "compileJava" {
        dependsOn("processResources")
    }
    "jar"(Jar::class) {
        enabled = true
    }
    "dokkaJavadoc"(DokkaTask::class) {
        noStdlibLink = true
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