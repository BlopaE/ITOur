plugins {
    id("com.android.application")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}


android {
    namespace = "com.example.itour_release"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.itour_release"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        useLibrary("org.apache.http.legacy")

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
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation ("com.github.mancj:MaterialSearchBar:0.8.2")
    implementation("com.google.android.gms:play-services-location:17.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment:2.7.4")
    implementation("androidx.navigation:navigation-ui:2.7.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.firebase:firebase-inappmessaging:20.4.0")
    implementation("com.google.android.libraries.places:places:3.3.0")
    implementation("androidx.activity:activity:1.8.0")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:3.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.karumi:dexter:5.0.0")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
}