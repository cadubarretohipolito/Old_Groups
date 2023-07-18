import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id ("java")
    id("xyz.jpenilla.run-paper") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("io.freefair.lombok") version "5.3.3.3"
}

group = "br.cadu.pro"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    // Paper Repo
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    // Jitpack
    maven("https://jitpack.io")
    //ProtocolLib Repo, constantly down
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://repo.mineinabyss.com/releases/")
    maven("https://repo.mineinabyss.com/snapshots/")
    //Developer versions
    maven("https://repo.md-5.net/content/groups/public/")
    //Json
    maven("https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind")
    // Inventory Framework
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")

}

dependencies{

    implementation("org.projectlombok:lombok:1.18.26")
    implementation("com.github.DevNatan:inventory-framework:2.5.4-rc.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")

    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:23.0.0")
    compileOnly("org.spigotmc:spigot:1.16.5-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0")

}




tasks {

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(16)
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        filteringCharset = Charsets.UTF_8.name()
    }
    runServer {
        minecraftVersion("1.16.5")
    }

    shadowJar {
        mergeServiceFiles()

        archiveFileName.set("RealmGroups.jar")
        destinationDirectory.set(file("C:/Users/ce641/Documents/project/server-skyblock/plugins"))

        dependencies {
            exclude(dependency("org.yaml:snakeyaml"))
        }

    }

    runServer {
        minecraftVersion("1.16.5")
    }

    build {
        dependsOn(shadowJar)
    }
}

bukkit{
    main = "br.cadu.pro.groups.RealmGroups"
    foliaSupported = true
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    apiVersion = "1.16"
    prefix = "Users"

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(16))
}

