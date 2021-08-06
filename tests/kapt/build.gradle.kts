plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
  id("com.apollographql.apollo3")
}

dependencies {
  implementation("com.apollographql.apollo3:apollo-runtime")
  implementation("com.apollographql.apollo3:apollo-normalized-cache")
  implementation("com.apollographql.apollo3:apollo-mockserver")
  testImplementation(kotlin("test-junit"))
  kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
}

apollo {
  packageName.set("kapt")
}


android {
  compileSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.compileSdkVersion").toString().toInt())

  defaultConfig {
    minSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.minSdkVersion").toString().toInt())
    targetSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.targetSdkVersion").toString().toInt())
  }
}
