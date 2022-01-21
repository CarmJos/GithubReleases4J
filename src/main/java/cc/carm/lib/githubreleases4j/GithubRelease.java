package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GithubRelease {

	protected static @NotNull GithubRelease of(@NotNull String owner, @NotNull String repository,
											   @Nullable String token,
											   @NotNull JSONObject contents) {
		return new GithubRelease(owner, repository, token, contents);
	}

	protected static @NotNull GithubRelease of(@NotNull String owner, @NotNull String repository,
											   @NotNull JSONObject contents) {
		return of(owner, repository, null, contents);
	}

	public final @NotNull String owner;
	public final @NotNull String repository;
	protected @Nullable String authToken;

	private final @NotNull JSONObject contents;

	protected GithubRelease(@NotNull String owner, @NotNull String repository,
							@Nullable String authToken, @NotNull JSONObject contents) {
		this.owner = owner;
		this.repository = repository;
		this.authToken = authToken;

		this.contents = contents;
	}

	protected @NotNull JSONObject getContents() {
		return contents;
	}

	public @NotNull String getOwner() {
		return owner;
	}

	public @NotNull String getRepository() {
		return repository;
	}

	protected @Nullable String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(@Nullable String authToken) {
		this.authToken = authToken;
	}

	public int getID() {
		return getContents().getInt("id");
	}

	public @NotNull String getTagName() {
		return getContents().getString("tag_name");
	}

	public @NotNull String getName() {
		return getContents().getString("name");
	}

	public @NotNull String getBody() {
		return getContents().getString("body");
	}

	public boolean isDraft() {
		return getContents().getBoolean("draft");
	}

	public boolean isPrerelease() {
		return getContents().getBoolean("prerelease");
	}

	public @Nullable Date getCreateTime() {
		return GithubReleases4J.parseDate(getContents().getString("created_at"));
	}

	public @Nullable Date getPublishTime() {
		return GithubReleases4J.parseDate(getContents().getString("published_at"));
	}

	public @NotNull String getNodeID() {
		return getContents().getString("node_id");
	}


	public @NotNull String getTagCommitIsh() {
		return getContents().getString("target_commitish");
	}


	public @NotNull String getURL() {
		return getContents().getString("url");
	}

	public @NotNull String getHTMLUrl() {
		return getContents().getString("html_url");
	}

	public @NotNull String getAssetsURL() {
		return getContents().getString("assets_url");
	}

	public @NotNull String getUploadURL() {
		return getContents().getString("upload_url");
	}

	public String getTarballURL() {
		return getContents().getString("tarball_url");
	}

	public String getZipBallURL() {
		return getContents().getString("zipball_url");
	}

	public @Nullable String getDiscussionURL() {
		return getContents().getString("discussion_url");
	}

	public GithubUser getAuthor() {
		return Optional.ofNullable(getContents().getJSONObject("author"))
				.map(GithubUser::of)
				.orElse(null);
	}

	public List<GithubAsset> getAssets() {
		JSONArray assetsArray = getContents().getJSONArray("assets");
		if (assetsArray == null) return new ArrayList<>();
		return IntStream.range(0, assetsArray.length())
				.mapToObj(assetsArray::getJSONObject)
				.map(assetsJSON -> GithubAsset.of(this, assetsJSON))
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return getContents().toString(0);
	}


}
