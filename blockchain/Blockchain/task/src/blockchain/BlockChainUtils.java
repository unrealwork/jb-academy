package blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BlockChainUtils {
    private BlockChainUtils() {
    }

    static boolean isProved(final String hash, int requiredZeroes) {
        if (requiredZeroes > hash.length()) {
            return false;
        }
        for (int i = 0; i < requiredZeroes; i++) {
            if (hash.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    static MessageDigest SHA256Digest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
