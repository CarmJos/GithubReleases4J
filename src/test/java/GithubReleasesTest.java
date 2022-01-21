import cc.carm.lib.githubreleases4j.GithubAsset;
import cc.carm.lib.githubreleases4j.GithubRelease;
import cc.carm.lib.githubreleases4j.GithubReleases4J;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GithubReleasesTest {

	public static boolean DOWNLOAD = true;
	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void onTest() {

		GithubReleases4J.listReleases("CarmJos", "EasyPlugin")
				.stream().limit(2).forEach(GithubReleasesTest::printInfo);

		GithubRelease release = GithubReleases4J.getLatestRelease("CarmJos", "UltraDepository");
		if (release != null) {
			printInfo(release);
			release.getAssets().stream().findFirst().ifPresent(GithubReleasesTest::downloadAssets);
		}


	}

	private static void printInfo(@Nullable GithubRelease release) {
		if (release == null) System.out.println("# NULL");
		else {
			System.out.println("# " + release.getName() + " [" + FORMAT.format(release.getCreateTime()) + "]");
			List<GithubAsset> assets = release.getAssets();
			assets.forEach(GithubReleasesTest::printAssets);
		}
	}

	private static void printAssets(@Nullable GithubAsset assets) {
		if (assets == null) System.out.println("- NULL");
		else {
			System.out.println("- " + assets.getName() + " [" + assets.getSize() + "]");
		}
	}

	private static void downloadAssets(@Nullable GithubAsset assets) {
		if (!DOWNLOAD) return;
		if (assets == null) return;
		try {
			File file = assets.download(null);
			System.out.println("- at " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
