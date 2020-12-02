tasks.register("devRelease", Exec::class) {
    workingDir = rootDir
    commandLine = "./gradlew assembleDevelopRelease appDistributionUploadDevelopRelease".split(" ")
}
tasks.register("stagingRelease", Exec::class) {
    workingDir = rootDir
    commandLine = "./gradlew assembleStagingRelease appDistributionUploadStgblueRelease".split(" ")
}
tasks.register("productRelease", Exec::class) {
    workingDir = rootDir
    commandLine = "./gradlew assembleProductionRelease appDistributionUploadProductionRelease".split(" ")
}
