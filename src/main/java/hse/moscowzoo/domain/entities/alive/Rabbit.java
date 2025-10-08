package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Rabbit extends Herbo{
    private static final int DEFAULT_FOOD_CONSUMPTION = 1;

    public Rabbit(int inventoryNumber, String name, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, DEFAULT_FOOD_CONSUMPTION, kindnessLevel);
    }
}
