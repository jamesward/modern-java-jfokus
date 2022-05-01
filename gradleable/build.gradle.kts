plugins {
    application
    kotlin("jvm") version "1.6.21"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("net.bytebuddy:byte-buddy:1.10.8")
    implementation("net.bytebuddy:byte-buddy-agent:1.10.8")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.register<JavaExec>("HelloRecords") {
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    })
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("HelloRecords")
}

tasks.register<JavaExec>("HelloSum") {
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("HelloSum")
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    })
    jvmArgs("--enable-preview")
}

tasks.register<JavaExec>("HelloNullHelp") {
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    })
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("HelloNullHelp")
}
