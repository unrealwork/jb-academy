package blockchain;

public class BlockBuilder {
    private final long id;
    private long ts;
    private long magicNumber;
    private Block previousHashBlock;
    private String hash;
    private String data;

    public BlockBuilder(long id) {
        this.id = id;
    }

    public BlockBuilder ts(long ts) {
        this.ts = ts;
        return this;
    }

    public BlockBuilder magicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
        return this;
    }

    public BlockBuilder previousHashBlock(Block previousHashBlock) {
        this.previousHashBlock = previousHashBlock;
        return this;
    }

    public BlockBuilder hash(String hash) {
        this.hash = hash;
        return this;
    }

    public Block createBlock() {
        return new Block(id, ts > 0 ? ts : System.currentTimeMillis(), data, magicNumber, previousHashBlock, hash);
    }

    public BlockBuilder data(String msg) {
        this.data = msg;
        return this;
    }
}
