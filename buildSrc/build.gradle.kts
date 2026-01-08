plugins {
    `kotlin-dsl`
}



dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    // Spotless
    implementation(libs.spotless.plugin)

}
