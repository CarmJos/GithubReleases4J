package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class GithubUser {

	protected static GithubUser of(@NotNull JSONObject contents) {
		return new GithubUser(contents);
	}

	private final @NotNull JSONObject contents;

	private GithubUser(@NotNull JSONObject contents) {
		this.contents = contents;
	}

	protected @NotNull JSONObject getContents() {
		return contents;
	}

	public int getID() {
		return getContents().getInt("id");
	}

	public @NotNull String getLoginID() {
		return getContents().getString("login");
	}

	public @NotNull String getNodeID() {
		return getContents().getString("node_id");
	}

	public @Nullable String getAvatarURL() {
		return getContents().getString("avatar_url");
	}

	public @Nullable String getGravatarID() {
		return getContents().getString("gravatar_id");
	}

	public @NotNull String getURL() {
		return getContents().getString("url");
	}

	public @NotNull String getProfileURL() {
		return getContents().getString("html_url");
	}

	public @NotNull String getFollowersURL() {
		return getContents().getString("followers_url");
	}

	public @NotNull String getFollowingURL() {
		return getContents().getString("following_url");
	}

	public @NotNull String getFollowingURL(@NotNull String otherUsername) {
		return getFollowingURL().replace("{/other_user}", "/" + otherUsername);
	}

	public @NotNull String getGistsURL() {
		return getContents().getString("gists_url");
	}

	public @NotNull String getGistsURL(int gistID) {
		return getGistsURL().replace("{/gist_id}", "/" + gistID);
	}

	public @NotNull String getStarredURL() {
		return getContents().getString("starred_url");
	}

	public @NotNull String getStarredURL(@NotNull String owner, @NotNull String repo) {
		return getStarredURL().replace("{/owner}{/repo}", "/" + owner + "/" + repo);
	}

	public @NotNull String getSubscriptionsURL() {
		return getContents().getString("subscriptions_url");
	}

	public @NotNull String getOrganizationsURL() {
		return getContents().getString("organizations_url");
	}

	public @NotNull String getReposURL() {
		return getContents().getString("repos_url");
	}

	public @NotNull String getEventsURL() {
		return getContents().getString("events_url");
	}

	public @NotNull String getEventsURL(String privacy) {
		return getEventsURL().replace("{/privacy}", "/" + privacy);
	}

	public @NotNull String getReceivedEventsURL() {
		return getContents().getString("received_events_url");
	}

	public @NotNull String getType() {
		return getContents().getString("type");
	}

	public boolean isSiteAdmin() {
		return getContents().getBoolean("site_admin");
	}

	@Override
	public String toString() {
		return getContents().toString();
	}
}
