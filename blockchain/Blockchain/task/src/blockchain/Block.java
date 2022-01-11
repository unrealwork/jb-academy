package blockchain;

import java.security.MessageDigest;
import java.time.Duration;

import static blockchain.BlockChainUtils.SHA256Digest;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Block {
    private static final MessageDigest DIGEST = SHA256Digest();
    private final long id;
    private final long ts;
    private final Block previousBlock;
    private final String hash;
    private final long magicNumber;

    public Block(long id, long ts, long magicNumber, Block previousHashBlock, String hash) {
        this.id = id;
        this.ts = ts;
        this.magicNumber = magicNumber;
        this.previousBlock = previousHashBlock;
        this.hash = hash;
    }

    static Block first() {
        return Block.builder(0)
                .ts(System.currentTimeMillis())
                .hash("0")
                .createBlock();
    }

    public static String applySha256(String input) {
        /* Applies sha256 to our input */
        byte[] hash = DIGEST.digest(input.getBytes(UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte elem : hash) {
            String hex = Integer.toHexString(0xff & elem);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static BlockBuilder builder(long id) {
        return new BlockBuilder(id);
    }

    public long getId() {
        return id;
    }

    public long getTs() {
        return ts;
    }

    public String getHash() {
        return hash;
    }

    Duration miningDuration() {
        return Duration.ofMillis(ts - previousBlock.ts);
    }


    @Override
    public String toString() {
        final long durationSeconds = miningDuration().toSeconds();

        return String.format("Id: %d%nTimestamp: %d%n" +
                        "Magic number: %d%n" +
                        "Hash of the previous block: %n%s%n" +
                        "Hash of the block: %n%s%n" +
                        "Block was generating for %d seconds",
                id, ts, magicNumber, previousBlock.hash, hash, durationSeconds
        );
    }
}
