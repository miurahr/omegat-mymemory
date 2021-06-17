plugins {
    java
    checkstyle
    distribution
    maven
    id("org.omegat.gradle") version "1.5.3"
}

version = "0.0.1"
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
