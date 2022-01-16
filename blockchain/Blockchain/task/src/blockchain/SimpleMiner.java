package blockchain;

import blockchain.events.BasicEventManager;
import blockchain.events.EventListener;
import blockchain.events.EventManager;
import blockchain.events.MinedBlockData;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

import static blockchain.Block.applySha256;

public class SimpleMiner implements Miner {
    private static final EventManager<MinedBlockData> EVENT_MANAGER = BasicEventManager.create();

    private final BlockchainClient client;
    private final int id;

    SimpleMiner(BlockchainClient client, int id) {
        this.client = client;
        this.id = id;
    }

    public void addListener(final EventListener<MinedBlockData> listener) {
        EVENT_MANAGER.subscribe(listener);
    }


    @Override
    public int id() {
        return id;
    }

    @Override
    public Block mine() {
        while (client.isAvailable()) {
            final Block block = mineBlock();
            final ValidationResult validationResult = client.validate(block);
            if (validationResult.isValid()) {
                final MinedBlockData data = MinedBlockData.create(this, block, validationResult.getRequiredZeroes());
                EVENT_MANAGER.notify(data);
            }
        }
        return null;
    }

    private Block mineBlock() {
        try {
            Block lastBlock = client.last();
            long magicNumber = ThreadLocalRandom.current().nextLong();
            final String baseHash = lastBlock.getHash();
            final SecuredMessage msg = secureMessage(lastBlock.getId() == 0 ? null : "miner #" + id);
            String nextHash = applySha256(baseHash + magicNumber);
            return Block.builder(lastBlock.getId() + 1)
                    .magicNumber(magicNumber)
                    .previousHashBlock(lastBlock)
                    .hash(nextHash)
                    .data(msg)
                    .createBlock();
        } catch (Exception e) {
            return mineBlock();
        }
    }

    private SecuredMessage secureMessage(String s) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (s == null) {
            return null;
        }
        KeyPair pair = GenerateKeys.generate();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPrivate());
        final byte[] sourceData = s.getBytes(StandardCharsets.UTF_8);
        return SecuredMessage.fromDataWithKey(cipher.doFinal(sourceData), pair.getPublic());

    }
}
