package blockchain;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Deque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BlockChain implements Iterable<BlockChain.Block> {
    private final Lock lock = new ReentrantLock();
    private final Deque<Block> blocks;


    private BlockChain() {
        this.blocks = new ConcurrentLinkedDeque<>();
    }

    public static BlockChain getInstance() {
        return new BlockChain();
    }

    public static BlockChain withSize(final int size, int requiredZeroes) {
        final BlockChain chain = new BlockChain();
        for (int i = 0; i < size; i++) {
            chain.mine(requiredZeroes);
        }
        return chain;
    }

    public static MessageDigest SHA256Digest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public Block mine(final int requiredZeroes) {
        lock.lock();
        try {
            final BlockChain.Block block = blocks.isEmpty() ? Block.first(requiredZeroes) : blocks.peekLast().next(requiredZeroes);
            blocks.add(block);
            return block;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<Block> iterator() {
        return blocks.iterator();
    }

    @Override
    public void forEach(Consumer<? super Block> action) {
        blocks.forEach(action);
    }

    @Override
    public Spliterator<BlockChain.Block> spliterator() {
        return blocks.spliterator();
    }

    public static class Block {
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

        private static BlockChain.Block first(int requiredZeroes) {
            final Block baseBlock = new Block(0, System.currentTimeMillis(), 0, null, "0");
            long magicNumber = ThreadLocalRandom.current().nextLong();
            String nextHash = applySha256(UUID.randomUUID().toString() + magicNumber);
            while (!BlockChainUtils.isProved(nextHash, requiredZeroes)) {
                magicNumber = ThreadLocalRandom.current().nextLong();
                nextHash = applySha256(UUID.randomUUID().toString() + magicNumber);
            }
            return new BlockChain.Block(1, System.currentTimeMillis(), magicNumber, baseBlock, nextHash);
        }

        public static String applySha256(String input) {
            try {
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
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
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

        private BlockChain.Block next(int requiredZeroes) {
            long magicNumber = ThreadLocalRandom.current().nextLong();
            String nextHash = applySha256(UUID.randomUUID().toString() + magicNumber);
            while (!BlockChainUtils.isProved(nextHash, requiredZeroes)) {
                magicNumber = ThreadLocalRandom.current().nextLong();
                nextHash = applySha256(UUID.randomUUID().toString() + magicNumber);
            }

            return new BlockChain.Block(id + 1, System.currentTimeMillis(), magicNumber, this, nextHash);
        }

        @Override
        public String toString() {
            final long durationSeconds = Duration.ofMillis(ts - previousBlock.ts).toSeconds();
            return String.format("%nBlock:%nId: %d%nTimestamp: %d%n" +
                            "Magic number: %d%n" +
                            "Hash of the previous block: %n%s%n" +
                            "Hash of the block: %n%s%n" +
                            "Block was generating for %d seconds",
                    id, ts, magicNumber, previousBlock.hash, hash, durationSeconds
            );
        }
    }

}
