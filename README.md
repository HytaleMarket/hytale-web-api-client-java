# Hytale Web API Client (Java)
[![Build Status](https://external.build.hytale.market/api/badges/HytaleMarket/hytale-web-api-client-java/status.svg)](https://external.build.hytale.market/HytaleMarket/hytale-web-api-client-java) 
[![Version](https://img.shields.io/github/release/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) 
[![Total Downloads](https://img.shields.io/github/downloads/HytaleMarket/hytale-web-api-client-java/total.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases) 
[![License](https://img.shields.io/github/license/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/LICENSE.txt) 
[![Discord](https://img.shields.io/discord/531173479282901002.svg?style=flat-square)](https://hytale.market/discord)

## Table of Contents
* [Including the client in your project](#including-the-client-in-your-project)
   * [Using build or dependency management tool](#using-build-or-dependency-management-tool)
   * [Without build or dependency management tool](#without-build-or-dependency-management-tool)
* [Add to local Maven repository](#add-to-local-maven-repository)
* [Quick guide on how to use](#quick-guide-on-how-to-use)
   * [Creating an instance of `HytaleWebApiService`](#creating-an-instance-of-hytalewebapiservice)
   * [Executing a synchronous request](#executing-a-synchronous-request)
   * [Executing a asynchronous request](#executing-a-asynchronous-request)
   
## Including the client in your project
### Using build or dependency management tool
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

## Add to local Maven repository
#### Bash & Windows CMD

```bash
# HTTPS
git clone https://github.com/HytaleMarket/hytale-web-api-client-java && cd hytale-web-api-client-java && mvn install
# SSH
git clone git@github.com:HytaleMarket/hytale-web-api-client-java.git && cd hytale-web-api-client-java && mvn install
```
#### PowerShell
```bash
# HTTPS
git clone https://github.com/HytaleMarket/hytale-web-api-client-java; cd hytale-web-api-client-java; mvn install
# SSH
git clone git@github.com:HytaleMarket/hytale-web-api-client-java.git; cd hytale-web-api-client-java; mvn install
```

## Quick guide on how to use
### Creating an instance of `HytaleWebApiService`
In order to get an instance of [`HytaleWebApiService`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiService.java) you have to create one by calling the static factory method [`#createApiProvider()`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiManager.java#L41) of [`HytaleWebApiManager`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiManager.java). This will get you a fresh instance of `HytaleWebApiService` you can work with.  
```java
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();
```

If you want to use your custom `OkHttpClient` instance, provide it as a parameter for the [`#createApiProvider(OkHttpClient)`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiManager.java#L52) static factory method.
```java
final OkHttpClient myOkHttpClient = /* ... */ ;
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider(myOkHttpClient);
```

### Executing a synchronous request
```java
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
final List<BlogPostPreview> featuredPosts = apiService.getPublishedBlogPosts().execute().body();
```

### Executing a asynchronous request
```java
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
apiService.getPublishedBlogPosts().enqueue(new Callback<List<BlogPostPreview>>() {

    @Override
    public void onResponse(Call<List<BlogPostPreview>> call, Response<List<BlogPostPreview>> response) {
        if (response.isSuccessful()) {
            // Resource is available
            final List<BlogPostPreview> featuredPosts = response.body();
        } else {
            // Error handling
        }
    }

    @Override
    public void onFailure(Call<List<BlogPostPreview>> call, Throwable t) {
        // Error handling
    }
});
```
