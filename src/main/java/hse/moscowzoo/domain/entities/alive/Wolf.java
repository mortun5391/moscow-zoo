package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Wolf extends Predator{
    private static final int DEFAULT_FOOD_CONSUMPTION = 3;

    public Wolf(int inventoryNumber, String name, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, DEFAULT_FOOD_CONSUMPTION, kindnessLevel);
    }
}
