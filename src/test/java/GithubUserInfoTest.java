import cc.carm.lib.githubreleases4j.GithubRelease;
import cc.carm.lib.githubreleases4j.GithubReleases4J;
import cc.carm.lib.githubreleases4j.GithubUser;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class GithubUserInfoTest {

	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void onTest() {

		GithubRelease release = GithubReleases4J.getLatestRelease("CarmJos", "UltraDepository");
		if (release != null) {
			System.out.println("# " + release.getName() + " [" + FORMAT.format(release.getCreateTime()) + "]");

			GithubUser author = release.getAuthor();
			System.out.println("- " + author.getStarredURL("LSeng", "Kar"));
		}

	}


}
