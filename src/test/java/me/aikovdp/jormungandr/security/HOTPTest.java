package me.aikovdp.jormungandr.security;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HOTPTest {

    private static final String HOTP_SECRET = "K5QWCYLB";

    @ParameterizedTest
    @MethodSource("provideHotpValues")
    void testGenerateHotp(int counter, int expected) {
        int hotp = HOTP.generate(HOTP_SECRET, counter);
        assertEquals(hotp, expected);
        System.out.println(hotp);
    }

    static Stream<Arguments> provideHotpValues() {
        return Stream.of(
                arguments(1,     298206),
                arguments(2,     654328),
                arguments(3,     448715),
                arguments(10,    656872),
                arguments(15435, 300968)
        );
    }
}
