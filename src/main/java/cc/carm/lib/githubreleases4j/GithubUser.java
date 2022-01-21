package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class GithubUser {

	protected static GithubUser of(@NotNull JSONObject contents) {
		return new GithubUser(contents);
	}

	protected static GithubUser of(@NotNull String jsonString) {
		return of(new JSONObject(jsonString));
	}

	private final @NotNull JSONObject contents;

	private GithubUser(@NotNull JSONObject contents) {
		this.contents = contents;
	}

	protected @NotNull JSONObject getContents() {
		return contents;
	}

	@Override
	public String toString() {
		return getContents().toString(0);
	}
}
