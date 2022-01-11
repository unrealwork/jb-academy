package blockchain;

import blockchain.events.EventListener;
import blockchain.events.MinedBlockData;
import blockchain.events.RequiredZeroesData;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockChain chain = BlockChain.withSize(5);
        chain.start();
        List<MinedBlockData> minedList = new LinkedList<>();
        final MinerFactory factory = new ConcurrentMinerFactory();
        final EventListener<MinedBlockData> listener = minedList::add;
        for (int i = 0; i < 100; i++) {
            final BlockchainClient client = new BlockchainClientImpl(chain);
            final Miner miner = new SimpleMiner(client, i + 1);
            miner.addListener(listener);
            factory.register(miner);
        }

        chain.join();
        factory.stop();
        minedList.stream()
                .sorted(Comparator.comparing(data -> data.getBlock().getId()))
                .forEach(Main::handleMinedData);
    }

    private static void handleMinedData(MinedBlockData data) {
        String desc = new StringBuilder()
                .append(System.lineSeparator())
                .append("Block:")
                .append(System.lineSeparator())
                .append("Created by miner # ")
                .append(data.getMiner().id())
                .append(System.lineSeparator())
                .append(data.getBlock())
                .append(System.lineSeparator())
                .append(reqZeroesChangeDescription(data.getRequiredZeroesData()))
                .toString();
        System.out.println(desc);
    }

    private static String reqZeroesChangeDescription(RequiredZeroesData data) {
        if (data.getBefore() == data.getAfter()) {
            return "N stays the same";
        } else {
            if (data.getAfter() > data.getBefore()) {
                return "N was increased to " + data.getAfter();
            } else {
                return "N was decreased by " + (data.getBefore() - data.getAfter());
            }
        }
    }
}
