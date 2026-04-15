plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.rlr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rlr"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    // Lifecycle - ViewModel & LiveData
    implementation(libs.viewmodel)
    implementation(libs.livedata)

    // Room Database
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    implementation ("androidx.core:core-ktx:1.13.1")
//    implementation ("androidx.appcompat:appcompat:1.7.0")
//    implementation ("com.google.android.material:material:1.12.0")

    // Lifecycle - ViewModel & LiveData
//    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
//    implementation ("androidx.lifecycle:lifecycle-livedata:2.8.7")

    // Room Database
//    implementation ("androidx.room:room-runtime:2.6.1")
//    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    // RecyclerView
//    implementation ("androidx.recyclerview:recyclerview:1.3.2")

    // 其他你可能需要的
//    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
}