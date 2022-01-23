import cc.carm.lib.githubreleases4j.GithubAsset;
import cc.carm.lib.githubreleases4j.GithubRelease;
import cc.carm.lib.githubreleases4j.GithubReleases4J;
import cc.carm.lib.githubreleases4j.GithubUser;

import java.io.IOException;
import java.util.List;

public class GithubDemoChinese {

	public void demo() {

		String owner = "库主(用户名或组织名)";
		String repository = "库名";

		List<GithubRelease> releases = GithubReleases4J.listReleases("Owner", "RepoName");
		// 列出项目中所有发行版

		GithubRelease latestRelease = GithubReleases4J.getLatestRelease(
				owner, repository, "Token" // 如果是私有项目 则需要输入OAuth token
		); // 得到该库的最新发行

		if (latestRelease != null) {

			List<GithubAsset> assets = latestRelease.getAssets();
			// 得到该发行下的所有附件

			for (GithubAsset asset : assets) {
				try {
					asset.download(); // 使用原附件名直接下载
				} catch (IOException exception) {
					exception.printStackTrace();
				}

				GithubUser uploader = asset.getUploader(); // 得到附件的上传者

			}

			GithubUser author = latestRelease.getAuthor(); // 得到该发行的发布者

		}
	}

	public void checkUpdate() {

		String owner = "库主(用户名或组织名)";
		String repository = "库名";
		String version = "当前版本的 TagName";

		Integer behindVersions = GithubReleases4J.getVersionBehind(
				owner, repository, "Token",// 如果是私有项目 则需要输入OAuth token
				version
		);

		if (behindVersions == null) {
			System.out.println("检查更新失败! 请您手动检查版本更新。");
			System.out.println("下载地址 " + GithubReleases4J.getReleasesURL(owner, repository));
		} else if (behindVersions == 0) {
			System.out.println("检查完成，当前已是最新版本。");
		} else if (behindVersions > 0) {
			System.out.println("发现新版本! 目前已落后 " + behindVersions + " 个版本。");
			System.out.println("最新版下载地址 " + GithubReleases4J.getLatestReleaseURL(owner, repository));
		} else {
			System.out.println("检查更新失败! 当前版本未知，请您使用原生版本以避免安全问题。");
			System.out.println("最新版下载地址 " + GithubReleases4J.getLatestReleaseURL(owner, repository));
		}

	}

}
