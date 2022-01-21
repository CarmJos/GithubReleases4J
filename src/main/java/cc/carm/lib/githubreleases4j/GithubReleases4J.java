package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GithubReleases4J {

	private GithubReleases4J() {
	}

	public static String GITHUB_API_URL = "https://api.github.com";
	public static SimpleDateFormat GH_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public static @NotNull List<GithubRelease> listReleases(@NotNull String owner, @NotNull String repository,
															@Nullable String token) {
		try {
			JSONArray releasesArray = GitHubHttpUtils.getArray(buildURL(
					"%s/repos/%s/%s/releases", GITHUB_API_URL, owner, repository
			), token);

			return IntStream.range(0, releasesArray.length())
					.mapToObj(releasesArray::getJSONObject)
					.map(releaseJSON -> GithubRelease.of(owner, repository, token, releaseJSON))
					.collect(Collectors.toList());
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}

	public static @NotNull List<GithubRelease> listReleases(@NotNull String owner, @NotNull String repository) {
		return listReleases(owner, repository, null);
	}

	public static @Nullable GithubRelease getRelease(@NotNull String owner, @NotNull String repository,
													 @NotNull String releaseID, @Nullable String token) {

		try {
			JSONObject releaseJSON = GitHubHttpUtils.getObject(buildURL(
					"%s/repos/%s/%s/releases/%s", GITHUB_API_URL, owner, repository, releaseID
			), token);

			return GithubRelease.of(owner, repository, token, releaseJSON);
		} catch (IOException e) {
			return null;
		}

	}

	public static @Nullable GithubRelease getRelease(@NotNull String owner, @NotNull String repository,
													 @NotNull String releaseID) {
		return getRelease(owner, repository, releaseID, null);
	}

	public static @Nullable GithubRelease getReleaseByTag(@NotNull String owner, @NotNull String repository,
														  @NotNull String tagName, @Nullable String token) {
		return getRelease(owner, repository, "tags/" + tagName, token);
	}


	public static @Nullable GithubRelease getReleaseByTag(@NotNull String owner, @NotNull String repository,
														  @NotNull String tagName) {
		return getReleaseByTag(owner, repository, tagName, null);
	}

	public static @Nullable GithubRelease getLatestRelease(@NotNull String owner, @NotNull String repository,
														   @Nullable String token) {
		return getRelease(owner, repository, "latest", token);
	}

	public static @Nullable GithubRelease getLatestRelease(@NotNull String owner, @NotNull String repository) {
		return getLatestRelease(owner, repository, null);
	}

	private static String buildURL(@NotNull String url, Object... params) {
		return String.format(url, params);
	}

	@Contract("null->null")
	protected static @Nullable Date parseDate(@Nullable String dateString) {
		if (dateString == null) return null;
		try {
			return GH_TIME_FORMAT.parse(dateString);
		} catch (Exception exception) {
			return null;
		}
	}

}
