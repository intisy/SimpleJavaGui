# Github Gradle

Archives containing JAR files are available as [releases](https://github.com/Blizzity/intisy/SimpleJavaGui/releases).

## Usage in private repos (faster)

 * Maven (inside the  file)
```xml
  <repository>
      <id>github</id>
      <url>https://maven.pkg.github.com/Blizzity/intisy/SimpleJavaGui</url>
      <snapshots><enabled>true</enabled></snapshots>
  </repository>
  <dependency>
      <groupId>io.github.intisy</groupId>
      <artifactId>intisy/SimpleJavaGui</artifactId>
      <version>1.1.1</version>
  </dependency>
```

 * Maven (inside the  file)
```xml
  <servers>
      <server>
          <id>github</id>
          <username><your-username></username>
          <password><your-access-token></password>
      </server>
  </servers>
```

 * Gradle (inside the  or  file)
```groovy
  repositories {
      maven {
          url "https://maven.pkg.github.com/Blizzity/intisy/SimpleJavaGui"
          credentials {
              username = "<your-username>"
              password = "<your-access-token>"
          }
      }
  }
  dependencies {
      implementation 'io.github.intisy:intisy/SimpleJavaGui:1.1.1'
  }
```

## Usage in public repos (slower and only works in gradle but safer)

 * Gradle (inside the  or  file)
```groovy
  plugins {
      id "io.github.intisy.github-gradle" version "1.1"
  }
  dependencies {
      githubImplementation "intisy:intisy/SimpleJavaGui:1.1.1"
  }
```
