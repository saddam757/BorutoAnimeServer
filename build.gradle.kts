
plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("io.ktor.plugin") version "2.1.2"
    kotlin("plugin.serialization") version "1.7.20"
    id("com.google.devtools.ksp") version "1.7.20-1.0.6"
}

group = "com.shcoding"
version = "0.0.1"

// Use KSP Generated sources
sourceSets.main {
    kotlin.srcDir("build/generated/ksp/main/kotlin")
}
application {
    mainClass.set("com.shcoding.ApplicationKt")

//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
}

dependencies {

    //Ktor Server
    implementation(libs.bundles.ktor)
    //Logback
    implementation(libs.logback.classic)
    //Koin Ktor
    implementation(libs.bundles.koin)
    ksp(libs.koin.ksp.compiler)
    //Ktor Server Test
    testImplementation(libs.bundles.ktorTest)
    //Kotlin Test
    testImplementation(libs.kotlin.test.junit)
}