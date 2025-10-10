package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Tiger extends Predator{
    private static final int DEFAULT_FOOD_CONSUMPTION = 8;
    public Tiger(int inventoryNumber, String name) {
        super(inventoryNumber, name, DEFAULT_FOOD_CONSUMPTION);
    }
}
