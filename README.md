# Hytale Web API Client (Java)
[![Build Status](https://external.build.hytale.market/api/badges/HytaleMarket/hytale-web-api-client-java/status.svg)](https://external.build.hytale.market/HytaleMarket/hytale-web-api-client-java) [![Version](https://img.shields.io/github/release/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) [![Total Downloads](https://img.shields.io/github/downloads/HytaleMarket/hytale-web-api-client-java/total.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases) [![License](https://img.shields.io/github/license/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/LICENSE.txt) [![Discord](https://img.shields.io/discord/531173479282901002.svg?style=flat-square)](https://hytale.market/discord)

## Table of Contents
* [Getting started](#getting-started)
   * [With build or dependency management tool](#with-build-or-dependency-management-tool)
   * [Without build or dependency management tool](#without-build-or-dependency-management-tool)
   
## Getting started
### With build or dependency management tool
<details>
  <summary>Maven</summary>
  
```xml
<repositories>
    <repository>
        <id>repository.hytale.market</id>
        <url>https://repository.hytale.market/public-releases/</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>market.hytale.rest</groupId>
        <artifactId>hytale-web-api-client-java</artifactId>
        <version>2019.04.01-RELEASE</version>
    </dependency>
</dependencies>
```
</details>
<details>
  <summary>Gradle</summary>
  
```gradle
allprojects {
    repositories {
        maven { url 'https://repository.hytale.market/public-releases/' }
    }
}
```
```gradle
dependencies {
    implementation 'market.hytale.rest:hytale-web-api-client-java:2019.04.01-RELEASE'
}
```
</details>
<details>
  <summary>SBT</summary>
  
```scala
resolvers += "repository.hytale.market" at "https://repository.hytale.market/public-releases/"
```
```scala
libraryDependencies += "market.hytale.rest" % "hytale-web-api-client-java" % "2019.04.01-RELEASE" 
```
</details>

### Without build or dependency management tool
You can [download the latest version from the releases page](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) and add the `.jar` file to your project libraries. We do recommend using a build and dependency management tool though.
