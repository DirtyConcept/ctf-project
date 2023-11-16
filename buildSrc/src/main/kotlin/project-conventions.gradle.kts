plugins {
    java
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()

    maven("https://repo.maven.apache.org/maven2/")

    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:24.1.0")
}

group = "dev.sadghost"
version = "1.0.0-b1"
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
