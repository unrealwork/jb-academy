package blockchain;

public class BlockchainClientImpl implements BlockchainClient {
    private final BlockChain blockChain;

    public BlockchainClientImpl(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    @Override
    public Block last() {
        return blockChain.last();
    }

    @Override
    public ValidationResult validate(Block block) {
        return blockChain.validate(block);
    }

    @Override
    public boolean isAvailable() {
        return !blockChain.isCompleted();
    }
}
