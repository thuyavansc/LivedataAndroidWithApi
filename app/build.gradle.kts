plugins {
    id("com.android.application")
}

android {
    namespace = "au.com.softclient.livedata1"
    compileSdk = 34

    buildFeatures {
        viewBinding= true
    }

    defaultConfig {
        applicationId = "au.com.softclient.livedata1"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //
    //implementation 'com.squareup.retrofit2:retrofit:2.9.0' // Replace with the version you are using
    //implementation 'com.squareup.retrofit2:converter-gson:2.9.0' // For Gson serialization (replace with your preferred converter)
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2") // LiveData and ViewModel
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2") // LiveData and ViewModel
    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter (replace with your preferred converter)

}