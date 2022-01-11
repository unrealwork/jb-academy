package blockchain;


import blockchain.events.RequiredZeroesData;

import java.time.Duration;
import java.util.Deque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class BlockChain extends Thread implements Iterable<Block> {
    private final Deque<Block> blocks;
    private final Duration increaseDuration = Duration.ofSeconds(1);
    private final Duration decreaseDuration = Duration.ofSeconds(2);
    private final int size;
    private int requiredZeroes = 0;


    private BlockChain(final int size) {
        this.size = size;
        this.blocks = new ConcurrentLinkedDeque<>();
    }

    public static BlockChain withSize(final int size) {
        return new BlockChain(size);
    }

    synchronized ValidationResult validate(Block block) {
        if (!isCompleted() && block.getId() == blocks.size() + 1 && BlockChainUtils.isProved(block.getHash(), requiredZeroes)) {
            blocks.add(block);
            if (isCompleted()) {
                notifyAll();
            }
            final int nextReqZeroes = regulateRequiredZeroes(block);
            final RequiredZeroesData requiredZeroesData = RequiredZeroesData.create(this.requiredZeroes, nextReqZeroes);
            this.requiredZeroes = nextReqZeroes;
            return ValidationResult.create(requiredZeroesData, true);
        }
        return ValidationResult.create(null, false);
    }

    @Override
    public void run() {
        super.run();
        while (!isCompleted()) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    boolean isCompleted() {
        return blocks.size() >= size;
    }

    private int regulateRequiredZeroes(Block block) {
        final Duration miningDuration = block.miningDuration();
        if (miningDuration.compareTo(increaseDuration) < 0) {
            return requiredZeroes + 1;
        }
        if (miningDuration.compareTo(decreaseDuration) > 0) {
            return requiredZeroes - 1;
        }
        return requiredZeroes;
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
    public Spliterator<Block> spliterator() {
        return blocks.spliterator();
    }


    public Block last() {
        return blocks.isEmpty() ? Block.first() : blocks.peekLast();
    }
}
