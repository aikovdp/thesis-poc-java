package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.security.TOTP;

public class VerifyTOTPAction implements Action<VerifyTOTPAction.Input, Boolean> {

    @Override
    public Boolean execute(Input input) {
        int expected = TOTP.generate(input.key());

        return input.totp() == expected;
    }

    public record Input(
            String key,
            int totp
    ) {
    }
}
