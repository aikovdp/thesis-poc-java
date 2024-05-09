package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.actions.GetDatabaseUserAction.DatabaseUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDatabaseUserActionTest {
    @Test
    public void testDatabaseUserAction() {
        GetDatabaseUserAction action = new GetDatabaseUserAction("jdbc:sqlite:jormungandr.db");

        DatabaseUser user = action.execute(new GetDatabaseUserAction.Input("jsmith"));

        assertEquals(new DatabaseUser(1, "John", "Smith", "jsmith", "jsmith@example.org"), user);
    }
}
