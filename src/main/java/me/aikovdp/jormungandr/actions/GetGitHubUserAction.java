package me.aikovdp.jormungandr.actions;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.aikovdp.jormungandr.exceptions.ActionException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetGitHubUserAction implements Action<GetGitHubUserAction.Input, GetGitHubUserAction.GitHubUser> {
    private static final URI GITHUB_USERS_URI = URI.create("https://api.github.com/users/");

    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Override
    public GitHubUser execute(Input input) {
        try (var client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(GITHUB_USERS_URI.resolve(input.username))
                    .build();
            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            return gson.fromJson(response, GitHubUser.class);
        } catch (IOException e) {
            throw new ActionException("Error occurred trying to reach GitHub API", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ActionException("Thread was interrupted while trying to reach GitHub API", e);
        }
    }

    public record Input(
            String username
    ) {

    }

    public record GitHubUser(
            String login,
            String type,
            String name,
            String company,
            String location,
            int publicRepos,
            int publicGists,
            int followers,
            int following
    ) {}
}
