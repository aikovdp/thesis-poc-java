package me.aikovdp.jormungandr.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HOTPTest {

    @Test
    void testGenerateHotp() {
        int hotp = HOTP.generate("K5QWCYLB", 1);
        assertEquals(hotp, 298206);
        System.out.println(hotp);
    }
}
