# SignedVelocity

![Latest Version](https://img.shields.io/github/v/release/4drian3d/SignedVelocity?style=flat-square)
[![Discord](https://img.shields.io/discord/899740810956910683?color=7289da&logo=Discord&label=Discord&style=flat-square)](https://discord.gg/5NMMzK5mAn)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/7IbzD4Zm?logo=Modrinth&style=flat-square)](https://modrinth.com/plugin/signedvelocity)
[![Jenkins Build](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fci.codemc.io%2Fjob%2F4drian3d%2Fjob%2FSignedVelocity%2F&style=flat-square&label=Jenkins%20Build)
](https://ci.codemc.io/job/4drian3d/job/SignedVelocity/)

Allows you to cancel or modify messages or commands from Velocity without synchronization problems

## Requirements
- Java 21+
- Velocity 3.3.0+
#### **Backend:**
- Paper 1.19.4+ 
- Sponge 8.1/10+
- [Minestom](https://github.com/4drian3d/SignedVelocity?tab=readme-ov-file#minestom)
- Fabric 1.21+

## Features
- Transmit the modification and cancellation status of Velocity messages and commands to your backend server using plugin messages. This avoids chat chain synchronization problems and avoids Velocity's security check by correctly synchronizing messages.
- Chat reporting support using Velocity (can be disabled using external plugins like FreedomChat, **not recommended**)
- Ability to remove the unsecured chat warning when logging into each server. Requires [VPacketEvents](https://modrinth.com/plugin/vpacketevents) or [PacketEvents](https://modrinth.com/plugin/packetevents)

   ![SignedVelocitySignedStatus](https://github.com/4drian3d/SignedVelocity/assets/68704415/4a7e2bec-c167-4de1-b827-d188d0afaa56)

> [!WARNING]
> SignedVelocity-Proxy versions prior to 1.3.0 contain an exploit that can be used
> to replace the input of any player, and can give administrator permissions to malicious agents,
> it is recommended to upgrade to the latest version.
> SignedVelocity backend versions are not affected

## Installation
In order for SignedVelocity to work, you must install it on both Velocity and all your servers
### Velocity
- Download SignedVelocity-Proxy
- Drag and drop on your Velocity plugins folder
- Start your proxy
### Paper
- Download SignedVelocity-Paper
- Drag and drop on your Paper plugins folder
- Start your server
### Sponge
- Download the version of SignedVelocity-Sponge that is compatible with your server.
  SignedVelocity-Sponge-8 supports API 8.1 and 9, SignedVelocity-Sponge-10 supports API 10 and 11
- Drag and drop on your Sponge plugins folder
- Start your server
### Fabric
- Download the version of SignedVelocity Fabric that corresponds to your server version
- Drag and drop on your Fabric mods folder
- Start your server
### Minestom

In the case of Minestom, SignedVelocity from version 1.3.0 onwards is used in the form of a library
so that it can be included in your own implementation.

#### Maven Repository

##### Gradle

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.4drian3d:signedvelocity-minestom:1.3.0")
}
```

#### Example

```java
import io.github._4drian3d.signedvelocity.minestom.SignedVelocity;

// then...

SignedVelocity.initialize();
```

For older versions of Minestom, you can use SignedVelocity-Minestom 1.2.4 which comes as an extension

[![](https://www.bisecthosting.com/partners/custom-banners/6fa909d5-ad2b-42c2-a7ec-1c51f8b6384f.webp)](https://www.bisecthosting.com/4drian3d)

## Downloads

[![](https://raw.githubusercontent.com/Prospector/badges/master/modrinth-badge-72h-padded.png)](https://modrinth.com/plugin/signedvelocity)

### Why SignedVelocity if UnSignedVelocity already exists?

UnSignedVelocity is a plugin that removes the limitation in Velocity to block or modify chat or commands executed by players with versions 1.19.1 or higher and who have a valid SignedKey. Although this works most of the time, there are issues that have arisen since version 1.19.3, which, as Mojang has implemented more security checks in the chat reporting system, has driven players kicked out of the proxy.

SignedVelocity solves all these problems, synchronizing the blocking and modification of chat and commands to the backend server, where it is possible to modify the chat.

[![Watch the video](https://img.youtube.com/vi/5bfYy1kQwGk/maxresdefault.jpg)](https://www.youtube.com/watch?v=5bfYy1kQwGk)

## Metrics
[![metrics](https://bstats.org/signatures/velocity/SignedVelocity.svg)](https://bstats.org/plugin/velocity/SignedVelocity/18937)
