package blockchain;

public interface BlockchainClient {
    Block last();
    ValidationResult validate(Block block);

    boolean isAvailable();
}
