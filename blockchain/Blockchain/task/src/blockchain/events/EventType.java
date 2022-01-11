package blockchain.events;

public enum EventType {
    MINED(MinedBlockData.class);
    
    private final Class<?> dataTypeClass;

    EventType(Class<?> minedBlockDataClass) {
        this.dataTypeClass = minedBlockDataClass;
    }
}
