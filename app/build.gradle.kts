plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.digitaldukan"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.digitaldukan"
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //picashow
    implementation ("com.squareup.picasso:picasso:2.8")
    //shimmer effect
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
    //Moshi
    //We can also use moshi libary as alternative of Gson
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")


}