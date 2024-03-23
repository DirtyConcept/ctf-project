plugins {
    id("project-conventions")

    id("io.papermc.paperweight.userdev") version "1.5.5"

    id("com.github.johnrengelman.shadow") version "8.1.1"
}

dependencies {
    implementation("io.micronaut:micronaut-inject-java:4.3.12")
    implementation(project(":ctf-api"))
    annotationProcessor("io.micronaut:micronaut-inject-java:4.3.12")

    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}