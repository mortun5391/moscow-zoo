package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.interfaces.IAlive;
import hse.moscowzoo.domain.interfaces.IInventory;
import hse.moscowzoo.domain.valueobjects.HealthStatus;

public abstract class Animal implements IAlive, IInventory {
    private int inventoryNumber;
    private String name;
    private int dailyFoodConsumption;
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

    @Override
    public void setInventoryNumber(int number) {
        this.inventoryNumber = number;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setDailyFoodConsumption(int dailyFoodConsumption) {
        this.dailyFoodConsumption = dailyFoodConsumption;
    }
}
