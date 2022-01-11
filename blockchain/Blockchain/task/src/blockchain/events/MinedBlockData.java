package blockchain.events;

import blockchain.Block;
import blockchain.Miner;

public class MinedBlockData {
    private final Miner miner;
    private final Block block;

    public RequiredZeroesData getRequiredZeroesData() {
        return requiredZeroesData;
    }

    private final RequiredZeroesData requiredZeroesData;

    private MinedBlockData(Miner miner, Block block, RequiredZeroesData requiredZeroesData) {
        this.miner = miner;
        this.block = block;
        this.requiredZeroesData = requiredZeroesData;
    }

    public static MinedBlockData create(Miner miner, Block block, RequiredZeroesData requiredZeroes) {
        return new MinedBlockData(miner, block, requiredZeroes);
    }

    public Miner getMiner() {
        return miner;
    }

    public Block getBlock() {
        return block;
    }
}
