import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("com.diffplug.spotless")
}

val libs = the<LibrariesForLibs>()

spotless {
    kotlinGradle {
        ktfmt(libs.versions.ktfmt.get()).googleStyle()

        // Configuration from .editorconfig
        trimTrailingWhitespace()
        leadingTabsToSpaces(2)
        endWithNewline()
    }

    kotlin {
        ktfmt(libs.versions.ktfmt.get()).googleStyle()
        target("buildSrc/**/*.kt","**/*.kt")
        targetExclude("buildSrc/build/**")
        // Configuration from .editorconfig
        trimTrailingWhitespace()
        leadingTabsToSpaces(2)
        endWithNewline()
    }
}
