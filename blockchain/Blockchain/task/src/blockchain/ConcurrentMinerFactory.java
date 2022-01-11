package blockchain;

import blockchain.events.EventManager;
import blockchain.events.MinedBlockData;
import blockchain.events.BasicEventManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMinerFactory implements MinerFactory {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final EventManager<MinedBlockData> eventManager = BasicEventManager.create();


    @Override
    public void start() {
    }

    @Override
    public void register(Miner miner) {
        executor.execute(miner::mine);
    }

    @Override
    public void stop() throws InterruptedException {
        executor.shutdown();
        boolean isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
        if (!isTerminated) {
            throw new IllegalStateException("Unable to shutdown executor service");
        }
    }
}
