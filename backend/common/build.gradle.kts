plugins {
    `java-library`
    `maven-publish`
}

java {
    withSourcesJar()
    withJavadocJar()
}

dependencies {
    compileOnly(libs.annotations)
    compileOnly(libs.slf4j.simple)
}

// Publish to Everbuild Maven
publishing {
    publications {
        create<MavenPublication>("maven") {
            repositories {
                maven {
                    credentials {
                        username = property("username")!! as String
                        password = property("password")!! as String
                    }
                    setUrl("https://mvn.everbuild.org/public")
                }
            }
            from(components["java"])
            pom {
                url.set("https://github.com/4drian3d/SignedVelocity")
                licenses {
                    license {
                        name.set("GNU General Public License version 3 or later")
                        url.set("https://opensource.org/licenses/GPL-3.0")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/4drian3d/SignedVelocity.git")
                    developerConnection.set("scm:git:ssh://git@github.com/4drian3d/SignedVelocity.git")
                    url.set("https://github.com/4drian3d/SignedVelocity")
                }
                developers {
                    developer {
                        id.set("4drian3d")
                        name.set("Adrian Gonzales")
                        email.set("adriangonzalesval@gmail.com")
                    }
                }
                issueManagement {
                    name.set("GitHub")
                    url.set("https://github.com/4drian3d/SignedVelocity/issues")
                }
                ciManagement {
                    name.set("GitHub Actions")
                    url.set("https://github.com/4drian3d/SignedVelocity/actions")
                }
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/4drian3d/SignedVelocity")
            }
            artifactId = "signedvelocity-minestom"
        }
    }
}