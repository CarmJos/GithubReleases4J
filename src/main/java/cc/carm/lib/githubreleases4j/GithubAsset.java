package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.util.Date;
import java.util.Optional;

public class GithubAsset {


	protected static GithubAsset of(@NotNull GithubRelease source, @NotNull JSONObject contents) {
		return new GithubAsset(source, contents);
	}

	protected static GithubAsset of(@NotNull GithubRelease source, @NotNull String jsonString) {
		return of(source, new JSONObject(jsonString));
	}

	private final @NotNull GithubRelease source;
	private final @NotNull JSONObject contents;

	private GithubAsset(@NotNull GithubRelease source, @NotNull JSONObject contents) {
		this.source = source;
		this.contents = contents;
	}

	protected @NotNull GithubRelease getSource() {
		return source;
	}

	protected @NotNull JSONObject getContents() {
		return contents;
	}

	public int getID() {
		return getContents().getInt("id");
	}

	public @NotNull String getURL() {
		return getContents().getString("url");
	}

	public @NotNull String getBrowserDownloadURL() {
		return getContents().getString("browser_download_url");
	}

	public @NotNull String getNodeID() {
		return getContents().getString("node_id");
	}

	public @NotNull String getName() {
		return getContents().getString("name");
	}

	public @NotNull String getLabel() {
		return getContents().getString("label");
	}

	public @NotNull String getState() {
		return getContents().getString("state");
	}

	public @NotNull String getContentType() {
		return getContents().getString("content_type");
	}

	public int getSize() {
		return getContents().getInt("size");
	}

	public int getDownloadCount() {
		return getContents().getInt("download_count");
	}

	public @Nullable Date getCreateTime() {
		return GithubReleases4J.parseDate(getContents().getString("created_at"));
	}

	public @Nullable Date getUpdateTime() {
		return GithubReleases4J.parseDate(getContents().getString("updated_at"));
	}

	public File download() throws IOException {
		return download(null);
	}

	public File download(@Nullable String path, CopyOption... options) throws IOException {
		path = path == null ? getName() : path;
		return GitHubHttpUtils.download(getBrowserDownloadURL(), getSource().getAuthToken(), path, options);
	}

	public GithubUser getUploader() {
		return Optional.ofNullable(getContents().getJSONObject("uploader"))
				.map(GithubUser::of)
				.orElse(null);
	}

	@Override
	public String toString() {
		return getContents().toString(0);
	}
}
