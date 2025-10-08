package hse.moscowzoo.domain.entities.things;

import hse.moscowzoo.domain.interfaces.IInventory;

public abstract class Thing implements IInventory {
    private int inventoryNumber;
    private String name;

    public Thing(int inventoryNumber, String name) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
    }

    @Override
    public int getInventoryNumber() {
        return inventoryNumber;
    }

    @Override
    public String getName() {
        return name;
    }
}
