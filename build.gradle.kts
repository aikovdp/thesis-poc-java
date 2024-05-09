plugins {
    `java-library`
}

group = "me.aikovdp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("org.slf4j:slf4j-api:2.0.13")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jdbi:jdbi3-core:3.45.1")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("ch.qos.logback:logback-classic:1.5.6")
    testRuntimeOnly("org.xerial:sqlite-jdbc:3.45.3.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.test {
    useJUnitPlatform()
}
