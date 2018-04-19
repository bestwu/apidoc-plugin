import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.internal.impldep.org.bouncycastle.crypto.tls.BulkCipherAlgorithm.idea
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import org.gradle.kotlin.dsl.withType

plugins {
    java
    idea
}

allprojects {
    apply {
        plugin("java")
        plugin("idea")
    }

    idea {
        module {
            inheritOutputDirs = false
            isDownloadJavadoc = false
            isDownloadSources = true
            outputDir = java.sourceSets["main"].java.outputDir
            testOutputDir = java.sourceSets["test"].java.outputDir
        }
    }
}
subprojects {

    version = "1.2.10"

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    repositories {
        mavenLocal()
        jcenter()
    }
}

