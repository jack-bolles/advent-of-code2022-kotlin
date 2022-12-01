

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

    test {
        useJUnitPlatform()
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

dependencies{
    implementation("io.kotest", "kotest-assertions-api-jvm", "5.+")
    implementation("io.kotest", "kotest-assertions-core-jvm", "5.+")
    implementation("io.kotest", "kotest-assertions-shared-jvm", "5.+")
    implementation("io.kotest", "kotest-common-jvm", "5.+")
    implementation("dev.mrbergin", "result4k-kotest-matchers" , "1.0.0")
    implementation("org.junit.jupiter:junit-jupiter:5.9.0")
    implementation(kotlin("stdlib-jdk8"))
}
