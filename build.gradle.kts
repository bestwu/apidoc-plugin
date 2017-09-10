import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType


subprojects {

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    repositories {
        jcenter()
    }
}

