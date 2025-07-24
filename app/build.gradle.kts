plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.gpa.SoharCollege"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gpa.SoharCollege"
        minSdk = 30
        targetSdk = 35
        versionCode = 21
        versionName = "2.10"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation ("com.android.support:appcompat-v7:27.0.0")
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.gridlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}