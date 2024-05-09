package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.actions.GetGitHubUserAction.GitHubUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetGitHubUserActionTest {
    @Test
    public void testGitHubUserAction() {
        GetGitHubUserAction action = new GetGitHubUserAction();
        GitHubUser user = action.execute(new GetGitHubUserAction.Input(
                "octocat"
        ));

        assertEquals("octocat", user.login());
        assertEquals("The Octocat", user.name());
        assertEquals("@github", user.company());
    }
}
