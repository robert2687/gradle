import org.gradle.gradlebuild.unittestandcompile.ModuleType

plugins {
    `java-library`
    gradlebuild.classycle
}

dependencies {
    api(library("jsr305"))

    implementation(project(":baseServices"))
    implementation(project(":logging"))
    implementation(project(":processServices"))
    implementation(project(":workerProcesses"))
    implementation(project(":fileCollections"))
    implementation(project(":coreApi"))
    implementation(project(":modelCore"))
    implementation(project(":core"))
    implementation(project(":jvmServices"))
    implementation(project(":workers"))
    implementation(project(":platformBase"))
    implementation(project(":platformJvm"))
    implementation(project(":languageJvm"))
    implementation(project(":languageJava"))

    implementation(library("slf4j_api"))
    implementation(library("groovy"))
    implementation(library("guava"))
    implementation(library("asm"))
    implementation(library("inject"))

    testImplementation(project(":baseServicesGroovy"))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":launcher")))

    testRuntimeOnly(project(":runtimeApiInfo"))
    
    testFixturesApi(testFixtures(project(":languageJvm")))
    testFixturesImplementation(project(":core"))
    testFixturesImplementation(project(":internalTesting"))

    integTestImplementation(library("commons_lang"))
    integTestRuntimeOnly(project(":plugins"))
}

gradlebuildJava {
    moduleType = ModuleType.CORE
}

classycle {
    excludePatterns.set(listOf(
        "org/gradle/api/internal/tasks/compile/**",
        "org/gradle/api/tasks/javadoc/**"
    ))
}
