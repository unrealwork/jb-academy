package blockchain;

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
}
