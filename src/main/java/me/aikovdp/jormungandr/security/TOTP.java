package me.aikovdp.jormungandr.security;

import java.time.ZonedDateTime;

public final class TOTP {

    public static final int TIME_STEP_SECONDS = 30;

    private TOTP() {}

    public static int generate(String key) {
        long counter = ZonedDateTime.now().toEpochSecond() / TIME_STEP_SECONDS;
        return HOTP.generate(key, counter);
    }
}
