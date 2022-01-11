package blockchain;

import blockchain.events.EventListener;
import blockchain.events.MinedBlockData;

public interface Miner {
    public static SimpleMiner simple(BlockchainClient client, int id) {
        return new SimpleMiner(client, id);
    }

    int id();

    Block mine();

    void addListener(final EventListener<MinedBlockData> listener);
}
