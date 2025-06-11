import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}


android {
    namespace = "com.example.moviieapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moviieapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val apiKeyPropertiesFile = rootProject.file("local.properties")
        val apiKeyProperties = Properties()
        apiKeyProperties.load(FileInputStream(apiKeyPropertiesFile))

        buildConfigField("String", "API_KEY", apiKeyProperties.getProperty("API_KEY"))
        buildConfigField("String", "BASE_URL", apiKeyProperties.getProperty("BASE_URL"))
        buildConfigField("String", "BASE_URL_IMAGE", apiKeyProperties.getProperty("BASE_URL_IMAGE"))
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
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation("com.google.dagger:hilt-android:2.56.2")
    ksp(libs.hilt.compiler)

    //Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")


    //Coil
    implementation(libs.coil.compose)

    // Others - Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.compose.material:material-icons-extended:1.4.0")
    implementation("com.google.accompanist:accompanist-flowlayout:0.17.0")



    // Jetpack Compose
    implementation(libs.navigation.compose)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    //DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Splashscreen
    implementation("androidx.core:core-splashscreen:1.0.0")

    //Gson
    implementation("com.google.code.gson:gson:2.10")

    //Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Paging3
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha18")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Room
    implementation("androidx.room:room-ktx:2.4.2")
    implementation("androidx.room:room-runtime:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}