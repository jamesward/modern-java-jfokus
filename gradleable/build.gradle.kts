plugins {
    application
    kotlin("jvm") version "1.6.21"
    scala
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
    implementation("org.scala-lang:scala3-library_3:3.1.2")

    implementation("dev.zio:zio_3:2.0.0-RC5")
    testImplementation("dev.zio:zio-test_3:2.0.0-RC5")

    implementation("dev.optics:monocle-core_3:3.1.0")
    implementation("dev.optics:monocle-unsafe_3:3.1.0")
    implementation("dev.optics:monocle-macro_3:3.1.0")
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
    mainClass.set("adt.HelloRecords")
}

tasks.register<JavaExec>("HelloSum") {
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("adt.HelloSum")
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
    mainClass.set("nullability.HelloNullHelp")
}
