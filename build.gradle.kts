plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}

dependencies{
    testImplementation("io.kotest", "kotest-assertions-api-jvm", "5.+")
    testImplementation("io.kotest", "kotest-assertions-core-jvm", "5.+")
    testImplementation("io.kotest", "kotest-assertions-shared-jvm", "5.+")
    testImplementation("io.kotest", "kotest-common-jvm", "5.+")
    testImplementation("dev.mrbergin", "result4k-kotest-matchers" , "1.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}
