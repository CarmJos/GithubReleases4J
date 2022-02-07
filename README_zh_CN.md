```text
  _____ _ _   _           _     _____      _                          _  _       _ 
 / ____(_) | | |         | |   |  __ \    | |                        | || |     | |
| |  __ _| |_| |__  _   _| |__ | |__) |___| | ___  __ _ ___  ___  ___| || |_    | |
| | |_ | | __| '_ \| | | | '_ \|  _  // _ \ |/ _ \/ _` / __|/ _ \/ __|__   _|   | |
| |__| | | |_| | | | |_| | |_) | | \ \  __/ |  __/ (_| \__ \  __/\__ \  | || |__| |
 \_____|_|\__|_| |_|\__,_|_.__/|_|  \_\___|_|\___|\__,_|___/\___||___/  |_| \____/ 
                                                
```

README LANGUAGES [ [ENGLISH](README.md) | [**中文**](README_zh_CN.md) ]

# GithubReleases4J

[![version](https://img.shields.io/github/v/release/CarmJos/GithubReleases4J)](https://github.com/CarmJos/GithubReleases4J/releases)
[![License](https://img.shields.io/github/license/CarmJos/GithubReleases4J)](https://opensource.org/licenses/GPL-3.0)
[![workflow](https://github.com/CarmJos/GithubReleases4J/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/CarmJos/GithubReleases4J/actions/workflows/maven.yml)
![CodeSize](https://img.shields.io/github/languages/code-size/CarmJos/GithubReleases4J)
![](https://visitor-badge.glitch.me/badge?page_id=GithubReleases4J.readme)

GitHub Releases for Java , 基于 [GitHub REST API](https://docs.github.com/cn/rest/reference/releases) 实现。

本项目对 GitHub Releases 相关的信息进行了封装，方便开发直接进行使用。

## 包含功能

- Release 的基本信息
    - Tag版本号、标题、内容介绍等
- Release 的作者信息
    - ID 、头像、身份等
- Release 的附件信息
    - 附件的名称、类型、大小、下载链接等
    - 支持直接对附件进行下载

## 依赖方式

<details>
<summary>展开查看 Maven 依赖方式</summary>

```xml

<project>
    <repositories>
      
        <repository>
            <!--采用Maven中心库，安全稳定，但版本更新需要等待同步-->
            <id>maven</id>
            <name>Maven Central</name>
            <url>https://repo1.maven.org/maven2</url>
        </repository>
      
        <repository>
            <!--采用github依赖库，安全稳定，但需要配置 (推荐)-->
            <id>GithubReleases4J</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/CarmJos/GithubReleases4J</url>
        </repository>
      
        <repository>
            <!--采用我的私人依赖库，简单方便，但可能因为变故而无法使用-->
            <id>carm-repo</id>
            <name>Carm's Repo</name>
            <url>https://repo.carm.cc/repository/maven-public/</url>
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
<summary>展开查看 Gradle 依赖方式</summary>

```groovy
repositories {
  
    // 采用Maven中心库，安全稳定，但版本更新需要等待同步 
    mavenCentral()

    // 采用github依赖库，安全稳定，但需要配置 (推荐)
    maven { url 'https://maven.pkg.github.com/CarmJos/GithubReleases4J' }

    // 采用我的私人依赖库，简单方便，但可能因为变故而无法使用
    maven { url 'https://repo.carm.cc/repository/maven-public/' }
}

dependencies {
    api "cc.carm.lib:githubreleases4j:[LATEST RELEASE]"
}
```

</details>

## 开发示例

请 [**点击这里**](src/test/java/GithubDemoChinese.java) 查看示例代码，也可以 [点击这里](https://github.com/CarmJos/UltraDepository/blob/master/src/main/java/cc/carm/plugin/ultradepository/hooker/UpdateChecker.java) 查看实例项目。

## 支持与捐赠

若您觉得本项目做的不错，您可以 [点击这里](https://donate.carm.cc) 捐赠支持我！

## 开源协议

本项目源码采用 [The MIT License](https://opensource.org/licenses/MIT) 开源协议。

<details>
<summary>关于 MIT 协议</summary>

> MIT 协议可能是几大开源协议中最宽松的一个，核心条款是：
>
> 该软件及其相关文档对所有人免费，可以任意处置，包括使用，复制，修改，合并，发表，分发，再授权，或者销售。唯一的限制是，软件中必须包含上述版 权和许可提示。
>
> 这意味着：
> - 你可以自由使用，复制，修改，可以用于自己的项目。
> - 可以免费分发或用来盈利。
> - 唯一的限制是必须包含许可声明。
>
> MIT 协议是所有开源许可中最宽松的一个，除了必须包含许可声明外，再无任何限制。
>
> *以上文字来自 [五种开源协议GPL,LGPL,BSD,MIT,Apache](https://www.oschina.net/question/54100_9455) 。*
</details>
