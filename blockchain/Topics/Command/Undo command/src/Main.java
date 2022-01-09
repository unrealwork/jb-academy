interface Movable {
    int getX();

    void setX(int newX);

    int getY();

    void setY(int newY);
}

interface Storable {
    int getInventoryLength();

    String getInventoryItem(int index);

    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();

    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    private int startX;
    private int startY;


    @Override
    public void execute() {
        this.startX = entity.getX();
        this.startY = entity.getY();
        entity.setX(startX + xMovement);
        entity.setY(startY + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(startX);
        entity.setY(startY);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int index = -1;

    @Override
    public void execute() {
        this.index = freeIndex();
        if (index >= 0) {
            entity.setInventoryItem(index, item);
        }
    }

    private int freeIndex() {
        for (int i = 0; i < entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void undo() {
        if (index >= 0) {
            entity.setInventoryItem(index, null);
        }
    }
}
