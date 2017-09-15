
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import org.gradle.kotlin.dsl.withType

plugins {
    id("cn.bestwu.idea") version "0.0.4"
}

subprojects {

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    repositories {
        jcenter()
    }
}

