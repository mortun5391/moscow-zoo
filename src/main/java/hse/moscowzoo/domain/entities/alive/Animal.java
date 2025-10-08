package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.interfaces.IAlive;
import hse.moscowzoo.domain.interfaces.IInventory;
import hse.moscowzoo.domain.valueobjects.HealthStatus;
import lombok.Getter;
import lombok.Setter;

public abstract class Animal implements IAlive, IInventory {
    private int inventoryNumber;
    private String name;

    @Setter
    private int dailyFoodConsumption;

    @Setter
    @Getter
    private HealthStatus healthStatus;

    public Animal(int inventoryNumber, String name, int dailyFoodConsumption) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.dailyFoodConsumption = dailyFoodConsumption;
        this.healthStatus = HealthStatus.HEALTHY; // default
    }

    public abstract boolean canBeInContactZoo();

    @Override
    public int getInventoryNumber() {
        return inventoryNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDailyFoodConsumption() {
        return dailyFoodConsumption;
    }

}
