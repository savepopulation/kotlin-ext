/*
 * Core Libraries
 */
object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
}

/*
 * Support Libraries
 */
object SupportLibraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.xVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.xVersion}"
    const val design = "com.google.android.material:material:${Versions.supportDesignVersion}"
}

/*
 * Test Libraries
 */
object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val runnner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}