package cc.carm.lib.githubreleases4j;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class GitHubHttpUtils {

	private GitHubHttpUtils() {
	}

	protected static JSONObject getObject(@NotNull String urlString, @Nullable String token) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "GithubReleases4J");
		if (token != null) {
			conn.setRequestProperty("Authorization", "token " + token);
		}
		conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
		conn.connect();

		InputStream in = conn.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		String responseBody = reader.lines().collect(Collectors.joining(System.lineSeparator()));
		reader.close();
		return new JSONObject(responseBody);
	}

	protected static JSONArray getArray(@NotNull String urlString, String token) throws IOException {
		URL url = new URL(urlString);

		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "GithubReleases4J");
		if (token != null) {
			conn.setRequestProperty("Authorization", "token " + token);
		}
		conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
		conn.connect();

		InputStream in = conn.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		String responseBody = reader.lines().collect(Collectors.joining(System.lineSeparator()));
		reader.close();

		return new JSONArray(responseBody);
	}

	protected static File download(@NotNull String urlString, @Nullable String token,
								   @NotNull String path, CopyOption... copyOptions) throws IOException {
		URL url = new URL(urlString);
		Path target = Paths.get(path);

		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "GithubReleases4J");
		if (token != null) {
			conn.setRequestProperty("Authorization", "token " + token);
		}
		conn.setRequestProperty("Accept", "application/vnd.github.v3+json");

		InputStream in = conn.getInputStream();

		Files.copy(in, target, copyOptions);
		in.close();

		return target.toFile();
	}


}
