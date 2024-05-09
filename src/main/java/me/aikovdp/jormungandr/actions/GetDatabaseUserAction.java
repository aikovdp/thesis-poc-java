package me.aikovdp.jormungandr.actions;

import org.jdbi.v3.core.Jdbi;

public class GetDatabaseUserAction implements Action<GetDatabaseUserAction.Input, GetDatabaseUserAction.DatabaseUser> {

    private final Jdbi jdbi;

    public GetDatabaseUserAction(String url) {
        this.jdbi = Jdbi.create(url);
    }

    @Override
    public DatabaseUser execute(Input input) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT id, given_name, family_name, username, email FROM users WHERE username = :username")
                        .bind("username", input.username)
                        .map((rs, ctx) -> new DatabaseUser(
                                        rs.getInt("id"),
                                        rs.getString("given_name"),
                                        rs.getString("family_name"),
                                        rs.getString("username"),
                                        rs.getString("email")
                                )
                        ).one()
        );
    }

    public record Input(
            String username
    ) {
    }

    public record DatabaseUser(
            int id,
            String givenName,
            String familyName,
            String username,
            String email
    ) {
    }
}
