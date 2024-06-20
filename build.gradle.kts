// Top-level build file where you can add configuration options common to all sub-projects/modules.
// build.gradle.kts (Project)
buildscript {
    val kotlinVersion by extra("1.8.10")
    val daggerVersion by extra("2.40.5")
    val rxjavaVersion by extra("3.1.3")
    val retrofitVersion by extra("2.9.0")
    val glideVersion by extra("4.13.0")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.dagger:dagger-compiler:$daggerVersion")
    }
}

allprojects {
    repositories {
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}