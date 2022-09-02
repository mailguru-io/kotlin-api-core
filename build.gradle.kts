import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.21.0")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
    id("java-library")
    id("org.jetbrains.dokka") version "1.7.10"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    kotlin("jvm") version "1.7.10"
}

base {
    group = "io.mailguru"
    version = "0.3.0-SNAPSHOT"
    archivesName.set("mailguru-api-core")
}

apply {
    plugin("com.vanniktech.maven.publish")
}

dependencies {

    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.10")

    api(platform("org.jetbrains.kotlin:kotlin-bom:1.7.10"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

plugins.withId("com.vanniktech.maven.publish.base") {
    configure<MavenPublishBaseExtension> {
        publishToMavenCentral(SonatypeHost.S01)
        signAllPublications()
        pom {
            name.set(project.name)
            description.set("Kotlin model library for usage with various mailguru.io APIs.")
            url.set("https://github.com/mlgr-io/kotlin-api-core")
            licenses {
                license {
                    name.set("GNU General Public License, Version 3")
                    url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
                }
            }
            developers {
                developer {
                    name.set("Sascha Weyers")
                    email.set("sw@mailguru.io")
                    organization.set("mailguru UG (haftungsbeschränkt)")
                    organizationUrl.set("https://mailguru.io")
                }
            }
            scm {
                connection.set("scm:git:git://github.com/mlgr-io/kotlin-api-core.git")
                developerConnection.set("scm:git:ssh://github.com:mlgr-io/kotlin-api-core.git")
                url.set("https://github.com/mlgr-io/kotlin-api-core")
            }
        }
        repositories {
            maven {
                url = if (version.toString().endsWith("SNAPSHOT")) {
                    uri(layout.buildDirectory.dir("repos/snapshots"))
                } else {
                    uri(layout.buildDirectory.dir("repos/releases"))
                }
            }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
