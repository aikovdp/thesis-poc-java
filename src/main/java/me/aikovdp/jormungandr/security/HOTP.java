package me.aikovdp.jormungandr.security;

import me.aikovdp.jormungandr.exceptions.ActionException;
import org.bouncycastle.util.encoders.Base32;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public final class HOTP {
    private HOTP() {}

    public static int generate(String key, long counter) {
        byte[] hash = hmacSha(key, longToByteArray(counter));

        return truncate(hash) % (int) Math.pow(10, 6);
    }

    public static byte[] hmacSha(String keyString, byte[] bytes) {
        Key key = new SecretKeySpec(Base32.decode(keyString), "RAW");
        Mac hmacSha1;
        try {
            hmacSha1 = Mac.getInstance("HmacSHA1");
            hmacSha1.init(key);
            return hmacSha1.doFinal(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new ActionException(e);
        }
    }

    private static byte[] longToByteArray(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(value);
        return buffer.array().clone();
    }

    private static int truncate(byte[] hash) {
        int offset = hash[hash.length - 1] & 0xf;
        ByteBuffer buffer = ByteBuffer.wrap(hash);
        // Get 4 bytes at offset index, and discard the most significant one
        return buffer.getInt(offset) & 0x7FFFFFFF;
    }
}
