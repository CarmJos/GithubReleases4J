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
		// Should not be the instance or use by other codes.
	}

	private static URLConnection createConnection(@NotNull String httpURL, @Nullable String token) throws IOException {
		URL url = new URL(httpURL);

		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "GithubReleases4J");
		conn.setRequestProperty("Accept", "application/vnd.github.v3+json");

		if (token != null) conn.setRequestProperty("Authorization", "token " + token);

		return conn;
	}

	private static String getResponse(@NotNull String httpURL, @Nullable String token) throws IOException {
		URLConnection connection = createConnection(httpURL, token);
		InputStream in = connection.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		String response = reader.lines().collect(Collectors.joining(System.lineSeparator()));
		reader.close();

		return response;
	}


	protected static JSONObject getObject(@NotNull String httpURL, @Nullable String token) throws IOException {
		return new JSONObject(getResponse(httpURL, token));
	}

	protected static JSONArray getArray(@NotNull String httpURL, String token) throws IOException {
		return new JSONArray(getResponse(httpURL, token));
	}

	protected static File download(@NotNull String httpURL, @Nullable String token,
								   @NotNull String path, CopyOption... copyOptions) throws IOException {
		Path target = Paths.get(path);

		URLConnection connection = createConnection(httpURL, token);
		InputStream in = connection.getInputStream();

		Files.copy(in, target, copyOptions);
		in.close();

		return target.toFile();
	}


}
