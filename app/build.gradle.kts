plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.n8.xmsflogbypass"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.n8.xmsflogbypass"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    compileOnly(files("libs/xposed-api-82.jar"))
}
