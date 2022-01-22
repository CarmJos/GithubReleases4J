import cc.carm.lib.githubreleases4j.GithubAsset;
import cc.carm.lib.githubreleases4j.GithubRelease;
import cc.carm.lib.githubreleases4j.GithubReleases4J;
import cc.carm.lib.githubreleases4j.GithubUser;

import java.io.IOException;
import java.util.List;

public class GithubDemo {

	public void demo() {

		List<GithubRelease> releases = GithubReleases4J.listReleases("Owner", "RepoName");
		// List a public repository's current existing releases.

		GithubRelease latestRelease = GithubReleases4J.getLatestRelease(
				"Owner", "RepoName",
				"Token" // OAuth token if it is a private repository.
		); // Get the latest release of the repository

		if (latestRelease != null) {

			List<GithubAsset> assets = latestRelease.getAssets();
			// Get the Release' assets list

			for (GithubAsset asset : assets) {
				try {
					asset.download(); // Download by the original file name.
				} catch (IOException exception) {
					exception.printStackTrace();
				}

				GithubUser uploader = asset.getUploader(); // Get the uploader of this asset.

			}

			GithubUser author = latestRelease.getAuthor(); // Get the author of this release.

		}
	}

	public void checkUpdate() {

		String owner = "Owner";
		String repository = "RepoName";

		Integer behindVersions = GithubReleases4J.getVersionBehind(
				owner, repository,
				"Token",// OAuth token if it is a private repository.
				"Current Version Tag"
		);

		if (behindVersions == null) {
			System.out.println("Check failed! Please check updates manually.");
			System.out.println("Download at " + GithubReleases4J.getReleasesURL(owner, repository));
		} else {
			if (behindVersions > 0) {
				System.out.println("Outdated! Now behind " + behindVersions + " versions.");
				System.out.println("Download latest version at " + GithubReleases4J.getLatestReleaseURL(owner, repository));
			} else {
				System.out.println("Now is using the latest version.");
			}

		}

	}

}
