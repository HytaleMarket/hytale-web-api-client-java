# Hytale Web API Client (Java)
### Java-based client implementation of the Hytale Web API
[![Version](https://img.shields.io/github/release/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) [![Total Downloads](https://img.shields.io/github/downloads/HytaleMarket/hytale-web-api-client-java/total.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/releases) [![JitPack](https://jitpack.io/v/market.hytale/hytale-web-api-client-java.svg?style=flat-square)](https://jitpack.io/#market.hytale/hytale-web-api-client-java) [![License](https://img.shields.io/github/license/HytaleMarket/hytale-web-api-client-java.svg?style=flat-square)](https://github.com/HytaleMarket/hytale-web-api-client-java/LICENSE.txt) [![Discord](https://img.shields.io/discord/531173479282901002.svg?style=flat-square)](https://hytale.market/discord)

---

### Features
- **Blog Post API**:
  Retrieve all [blog posts](https://hytale.com/news) that are either published, featured, or archived. You can also retrieve a single blog post.
- **Job API**:
  Retrieve all jobs with detailed information [currently listed on the official website](https://hytale.com/jobs).

---

### Installation
You can either [download the latest version](https://github.com/HytaleMarket/hytale-web-api-client-java/releases/latest) and add the `.jar` file to your project libraries, or let one of the following build and dependency management tools take care for you:

#### [Maven](https://maven.apache.org/) (`pom.xml`)
Add the repository:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Add the dependency:
```xml
<dependencies>
    <dependency>
        <groupId>market.hytale.rest</groupId>
        <artifactId>hytale-web-api-client-java</artifactId>
        <version>2019.04.01-RELEASE</version>
    </dependency>
</dependencies>
```

#### [Gradle](https://gradle.org/) (`build.gradle`)
Add the repository:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency:
```gradle
dependencies {
    implementation 'market.hytale.rest:hytale-web-api-client-java:2019.04.01-RELEASE'
}
```

#### [sbt](https://www.scala-sbt.org/) (`build.sbt`)
Add the repository:
```scala
resolvers += "jitpack" at "https://jitpack.io"
```
Add the dependency:
```scala
libraryDependencies += "market.hytale.rest" % "hytale-web-api-client-java" % "2019.04.01-RELEASE" 
```

---

### Usage
Create an instance of [`HytaleWebApiService`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/game/api/web/HytaleWebApiService.java) by calling the static [`HytaleWebApiManager.createApiProvider()`](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/src/main/java/market/hytale/game/api/web/HytaleWebApiManager.java#L41) method:
```java
HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
```
If you want to use a custom instance of `OkHttpClient`, pass an instance of it to the `createApiProvider` method.
&nbsp;

Make a synchronous request (be aware that this blocks the current Thread!):
```java
HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
List<BlogPostPreview> featuredPosts = apiService.getPublishedBlogPosts().execute().body();
```

Make an asynchronous request (recommended for most applications):
```java
HytaleWebApiService apiService = HytaleWebApiManager.createApiProvider();  
apiService.getPublishedBlogPosts().enqueue(new Callback<List<BlogPostPreview>>() {

    @Override
    public void onResponse(Call<List<BlogPostPreview>> call, Response<List<BlogPostPreview>> response) {
        if (response.isSuccessful()) {
            // Resource is available
            List<BlogPostPreview> featuredPosts = response.body();
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

---

### Dependencies
Don't worry, we already take care of our dependencies so that you definitely don't have to deal with them! However, we wanted to draw some attention to the libraries and tools we use for this project:
- [Project Lombok](https://projectlombok.org/)
- [Retrofit](https://square.github.io/retrofit/)
- [Moshi](https://github.com/square/moshi)
- [JUnit](https://junit.org/junit5/)

---

### License
This project is licensed under the Apache License, Version 2.0. See the [LICENSE.txt](https://github.com/HytaleMarket/hytale-web-api-client-java/blob/master/LICENSE.txt) file for details.

---

### Provided by Hytale Market
This project is provided by Hytale Market - an upcoming online marketplace for Hytale creations, resources and services. To learn more, check out https://hytale.market.
