import cc.carm.lib.githubreleases4j.GithubReleases4J;
import org.junit.Test;

public class GithubVersionCheckerTest {


	@Test
	public void test() {

		System.out.println(GithubReleases4J.getVersionBehind("CarmJos", "UltraDepository", "1.3.4"));

		System.out.println(GithubReleases4J.getVersionBehind("CarmJos", "UltraDepository", "v1.2.0"));

		System.out.println(GithubReleases4J.getVersionBehind("CarmJos", "UltraDepository", "TEST"));

		System.out.println(GithubReleases4J.getVersionBehind("CarmJos", "NULL", "TEST"));

		System.out.println("Download at " + GithubReleases4J.getReleaseURLByTag("CarmJos", "UltraDepository", "1.3.4"));
		System.out.println("Download at " + GithubReleases4J.getLatestReleaseURL("CarmJos", "UltraDepository"));

	}
}
