plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  id("spotless-conventions")
}

android {
  namespace = "edu.seminar.ouronlyhome"
  compileSdk { version = release(36) }

  defaultConfig {
    applicationId = "edu.seminar.ouronlyhome"
    minSdk = 35
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  signingConfigs {
    create("release") {
      // Falls ENV Var existiert, nutze sie (CI), sonst lokal (optional)
      storeFile = file(System.getenv("SIGNING_KEY_STORE_PATH") ?: "lokaler_pfad.jks")
      storePassword = System.getenv("SIGNING_STORE_PASSWORD")
      keyAlias = System.getenv("SIGNING_KEY_ALIAS")
      keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
    }
  }

  buildTypes {
    release {
      signingConfig = signingConfigs.getByName("release")
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions { jvmTarget = "11" }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.constraintlayout)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
}
