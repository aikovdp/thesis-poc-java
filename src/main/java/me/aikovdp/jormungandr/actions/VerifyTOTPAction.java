package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.security.TOTP;
import me.aikovdp.jormungandr.workflows.WorkflowContext;

public class VerifyTOTPAction implements Action<VerifyTOTPAction.Input, Boolean> {

    @Override
    public Boolean execute(Input input, WorkflowContext context) {
        int expected = TOTP.generate(input.key());

        return input.totp() == expected;
    }

    public record Input(
            String key,
            int totp
    ) {
    }
}
