package blockchain;

public interface MinerFactory {
    void start();
    void register(Miner miner);
    void stop() throws InterruptedException;
}
