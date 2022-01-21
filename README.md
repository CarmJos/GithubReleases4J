```text
  _____ _ _   _           _     _____      _                          _  _       _ 
 / ____(_) | | |         | |   |  __ \    | |                        | || |     | |
| |  __ _| |_| |__  _   _| |__ | |__) |___| | ___  __ _ ___  ___  ___| || |_    | |
| | |_ | | __| '_ \| | | | '_ \|  _  // _ \ |/ _ \/ _` / __|/ _ \/ __|__   _|   | |
| |__| | | |_| | | | |_| | |_) | | \ \  __/ |  __/ (_| \__ \  __/\__ \  | || |__| |
 \_____|_|\__|_| |_|\__,_|_.__/|_|  \_\___|_|\___|\__,_|___/\___||___/  |_| \____/ 
                                                
```

README LANGUAGES [ [ENGLISH](README_enUS.md) | [中文](README.md) ]

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

```java
import cc.carm.lib.githubreleases4j.*;

import java.io.IOException;

public class demo {

	public void onTest() {

		List<GithubRelease> releases = GithubReleases4J.listReleases("作者名", "项目名");
		//获取Releases列表

		GithubRelease latestRelease = GithubReleases4J.getLatestRelease(
				"作者名", "项目名",
				"Token" // 如果是私有项目，可以填写一个OAuth Token来获取信息和下载构件
		); // 获得最后一次的Release

		if (lastRelease != null) {

			List<GithubAsset> assets = latestRelease.getAssets();
			// 获取该 Release 的附件列表

			for (GithubAsset asset : assets) {
				try {
					asset.download(null); // 以默认名称下载到当前目录
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}

			GithubUser author = latestRelease.getAuthor(); //获取该Release的作者

		}
	}

}
```

## 支持与捐赠

若您觉得本项目做的不错，您可以 [点击这里](https://donate.carm.cc) 捐赠支持我！

## 开源协议

本项目源码采用 [GNU General Public License v3.0](https://opensource.org/licenses/GPL-3.0) 开源协议。

<details>
<summary>关于 GPL 协议</summary>

> GNU General Public Licence (GPL) 有可能是开源界最常用的许可模式。GPL 保证了所有开发者的权利，同时为使用者提供了足够的复制，分发，修改的权利：
>
> #### 可自由复制
> 你可以将软件复制到你的电脑，你客户的电脑，或者任何地方。复制份数没有任何限制。
> #### 可自由分发
> 在你的网站提供下载，拷贝到U盘送人，或者将源代码打印出来从窗户扔出去（环保起见，请别这样做）。
> #### 可以用来盈利
> 你可以在分发软件的时候收费，但你必须在收费前向你的客户提供该软件的 GNU GPL 许可协议，以便让他们知道，他们可以从别的渠道免费得到这份软件，以及你收费的理由。
> #### 可自由修改
> 如果你想添加或删除某个功能，没问题，如果你想在别的项目中使用部分代码，也没问题，唯一的要求是，使用了这段代码的项目也必须使用 GPL 协议。
>
> 需要注意的是，分发的时候，需要明确提供源代码和二进制文件，另外，用于某些程序的某些协议有一些问题和限制，你可以看一下 @PierreJoye 写的 Practical Guide to GPL Compliance 一文。使用 GPL 协议，你必须在源代码代码中包含相应信息，以及协议本身。
>
> *以上文字来自 [五种开源协议GPL,LGPL,BSD,MIT,Apache](https://www.oschina.net/question/54100_9455) 。*
</details>
