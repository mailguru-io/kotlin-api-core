
// please take care about the missing kotlin version in the version variable here;
// it will be added in extra["kotlinVersion"] later, due to gradle architecture.
val versions = mapOf(
    "detekt" to "1.21.0",
    "dokka" to "1.7.10",
    "jackson" to "2.13.3",
    "junit-jupiter" to "5.9.0",
    "ktlint" to "11.0.0",
    "maven-publish" to "0.21.0",
).plus(extra["versions"] as Map<String, String>)

println("  > You may use the following named versions:")
println("  > " + versions.toSortedMap().map { it.key + " (" + it.value + ")" }.joinToString(", "))

extra["plugins"] = listOf(
    "com.vanniktech:gradle-maven-publish-plugin:" + versions["maven-publish"],
    "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:" + versions["detekt"],
    "org.jetbrains.dokka:dokka-gradle-plugin:" + versions["dokka"],
    "org.jlleitschuh.gradle:ktlint-gradle:" + versions["ktlint"],
)

// re-export
extra["versions"] = versions
