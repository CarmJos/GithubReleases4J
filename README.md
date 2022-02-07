```text
  _____ _ _   _           _     _____      _                          _  _       _ 
 / ____(_) | | |         | |   |  __ \    | |                        | || |     | |
| |  __ _| |_| |__  _   _| |__ | |__) |___| | ___  __ _ ___  ___  ___| || |_    | |
| | |_ | | __| '_ \| | | | '_ \|  _  // _ \ |/ _ \/ _` / __|/ _ \/ __|__   _|   | |
| |__| | | |_| | | | |_| | |_) | | \ \  __/ |  __/ (_| \__ \  __/\__ \  | || |__| |
 \_____|_|\__|_| |_|\__,_|_.__/|_|  \_\___|_|\___|\__,_|___/\___||___/  |_| \____/ 
                                                
```

README LANGUAGES [ [**ENGLISH**](README.md) | [中文](README_zh_CN.md) ]

# GithubReleases4J

[![version](https://img.shields.io/github/v/release/CarmJos/GithubReleases4J)](https://github.com/CarmJos/GithubReleases4J/releases)
[![License](https://img.shields.io/github/license/CarmJos/GithubReleases4J)](https://opensource.org/licenses/GPL-3.0)
[![workflow](https://github.com/CarmJos/GithubReleases4J/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/CarmJos/GithubReleases4J/actions/workflows/maven.yml)
![CodeSize](https://img.shields.io/github/languages/code-size/CarmJos/GithubReleases4J)
![Support](https://img.shields.io/badge/Minecraft-Java%201.16--Latest-green)
![](https://visitor-badge.glitch.me/badge?page_id=GithubReleases4J.readme)

GitHub Releases for Java , based on [GitHub REST API](https://docs.github.com/cn/rest/reference/releases) .

To provide an easy way to fetch updates and download assets.

## Functions

- Release Info
    - Tag Name
    - Release Name
    - Release Descriptions
    - ...
- Release's Author Info
    - Login ID
    - AvatarURL
    - ...
- Release's Assets Info
    - Name
    - Size
    - ...
- Release's Assets Download
- Update check methods. (See demo)

## Dependency Usage

<details>
<summary>Maven dependency</summary>

```xml

<project>
    <repositories>
      
        <repository>
            <!--Using central repository-->
            <id>maven</id>
            <name>Maven Central</name>
            <url>https://repo1.maven.org/maven2</url>
        </repository>
      
        <repository>
            <!--Using github packages-->
            <id>GithubReleases4J</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/CarmJos/GithubReleases4J</url>
        </repository>
      
    </repositories>

    <dependencies>
      
        <dependency>
            <groupId>cc.carm.lib</groupId>
            <artifactId>githubreleases4j</artifactId>
            <version>[LATEST RELEASE]</version>
            <scope>compile</scope>
        </dependency>
      
    </dependencies>

</project>
```

</details>

<details>
<summary>Gradle dependency</summary>

```groovy
repositories {
  
    mavenCentral() // Using central repository.
  
    // Using github packages.
    maven { url 'https://maven.pkg.github.com/CarmJos/GithubReleases4J' }
}

dependencies {
    api "cc.carm.lib:githubreleases4j:[LATEST RELEASE]"
}
```

</details>

## DEMO Code

Please [click here](src/test/java/GithubDemo.java) to read the demo codes.

## Open Source License.

The project using [The MIT License](https://opensource.org/licenses/MIT) .
