# Hytale Web API Client (Java)
[![Build Status](https://external.build.hytale.market/api/badges/HytaleMarket/hytale-web-api-client-java/status.svg)](https://external.build.hytale.market/HytaleMarket/hytale-web-api-client-java) 
[![Version](https://img.shields.io/github/release/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) 
[![Total Downloads](https://img.shields.io/github/downloads/HytaleMarket/hytale-web-api-client-java/total.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases) 
[![License](https://img.shields.io/github/license/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/LICENSE.txt) 
[![Discord](https://img.shields.io/discord/531173479282901002.svg?style=flat-square)](https://hytale.market/discord)

## Table of Contents
* [Features](#features)
* [Including the client in your project](#including-the-client-in-your-project)
   * [No build or dependency management tool](#no-build-or-dependency-management-tool)
   * [Using build or dependency management tool](#using-build-or-dependency-management-tool)
* [Quick guide on how to use](#quick-guide-on-how-to-use)
   * [Creating an instance of `HytaleWebApiService`](#creating-an-instance-of-hytalewebapiservice)
   * [Executing a synchronous request](#executing-a-synchronous-request)
   * [Executing a asynchronous request](#executing-a-asynchronous-request)
* [Used dependencies and tools](#used-dependencies-and-tools)
* [License](#license)

## Features
- **Blog Posts:** Retrieve all [blog posts](https://hytale.com/news) that are either published, featured, or archived. You can also retrieve a single blog post.
- **Jobs:** Retrieve all jobs with detailed information [currently listed on the official website](https://hytale.com/jobs).

## Including the client in your project
#### No build or dependency management tool
You can [download the latest version from the releases page](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) and add the `.jar` file to your project libraries. We do recommend using a build and dependency management tool though.

#### Using build or dependency management tool
<details>
  <summary>As Maven dependency</summary>

```xml
<!-- Add required repository -->
<repositories>
    <repository>
        <id>repository.hytale.market</id>
        <url>https://repository.hytale.market/public-releases/</url>
    </repository>
</repositories>

<!-- Add as dependency -->
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
  <summary>As Gradle dependency</summary>

```gradle
// Add required repository
allprojects {
    repositories {
        maven { url 'https://repository.hytale.market/public-releases/' }
    }
}

// Add as dependency
dependencies {
    implementation 'market.hytale.rest:hytale-web-api-client-java:2019.04.01-RELEASE'
}
```
</details>
<details>
  <summary>As SBT dependency</summary>

```scala
// Add required repository
resolvers += "repository.hytale.market" at "https://repository.hytale.market/public-releases/"

// Add as dependency
libraryDependencies += "market.hytale.rest" % "hytale-web-api-client-java" % "2019.04.01-RELEASE"
```
</details>

## Quick guide on how to use
#### Creating an instance of `HytaleWebApiService`
Create an instance of [`HytaleWebApiService`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiService.java) by calling the static [`HytaleWebApiManager#createApiProvider()`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiManager.java#L41) method:
```java
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();
```

If you would like to use your custom `OkHttpClient` instance, pass it as parameter to the [`HytaleWebApiManager#createApiProvider(OkHttpClient)`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/rest/api/web/HytaleWebApiManager.java#L52) static factory method.
```java
final OkHttpClient myOkHttpClient = /* ... */ ;
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider(myOkHttpClient);
```

#### Executing a synchronous request
```java
final HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
final List<BlogPostPreview> featuredPosts = apiService.getPublishedBlogPosts().execute().body();
```

#### Executing a asynchronous request
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

## Used dependencies and tools
Don't worry, we already take care of our dependencies so that you definitely don't have to deal with them! However, we wanted to draw some attention to the libraries and tools we use for this project.
- [Retrofit](https://square.github.io/retrofit/)
- [Moshi](https://github.com/square/moshi)
- [Project Lombok](https://projectlombok.org/)
- [JUnit](https://junit.org/junit5/)
- [Checkstyle](http://checkstyle.sourceforge.net/)

## License
This project is licensed under the Apache License, Version 2.0. See the [LICENSE.txt](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/LICENSE.txt) file for details.

### Provided by Hytale Market
This project is provided by Hytale Market - an upcoming online marketplace for Hytale creations, resources and services. To learn more, check out https://hytale.market.
