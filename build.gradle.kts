plugins {
    java
    checkstyle
    distribution
    maven
    id("org.omegat.gradle") version "1.5.3"
    id("com.palantir.git-version") version "0.12.3"
}

// calculate version string from git tag, hash and commit distance
fun getVersionDetails(): com.palantir.gradle.gitversion.VersionDetails = (extra["versionDetails"] as groovy.lang.Closure<*>)(
) as com.palantir.gradle.gitversion.VersionDetails
if (getVersionDetails().isCleanTag) {
    version = getVersionDetails().lastTag.substring(1)
} else {
    version = getVersionDetails().lastTag.substring(1) + "-" + getVersionDetails().commitDistance + "-" + getVersionDetails()
.gitHash + "-SNAPSHOT"
}

repositories {
    mavenLocal()
}
omegat {
    version = "5.5.0"
    pluginClass = "org.omegat.plugins.machinetranslators.MyMemoryTranslate"
}

dependencies {
    packIntoJar("com.fasterxml.jackson.core:jackson-core:2.12.3")
    packIntoJar("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    implementation("commons-lang:commons-lang:2.6")
}

checkstyle {
    isIgnoreFailures = true
    toolVersion = "7.1"
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING", "CHANGELOG.md")
        }
    }
}
