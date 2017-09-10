import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm") version "1.1.4-3"
    id("cn.bestwu.plugin-publish") version "0.0.6"
//    id("com.jfrog.artifactory") version "4.5.2"
}

group = "cn.bestwu.gradle"
version = "1.2.5"

dependencies {
    compile(gradleApi())
    compile(project(":apidoc"))
}

publish {
    projectUrl = "https://bitbucket.org/betterwu/apidoc-plugin"
    vcsUrl = "https://bestwu@bitbucket.org/betterwu/apidoc-plugin.git"
}

//发布到gradle plugins
gradlePlugin {
    (plugins) {
        "apidoc" {
            id = "cn.bestwu.apidoc"
            implementationClass = "cn.bestwu.gradle.apidoc.ApidocPlugin"
        }
    }
}
pluginBundle {
    (plugins) {
        "apidoc" {
            id = "cn.bestwu.apidoc"
            displayName = "apidoc"
        }
    }
}

