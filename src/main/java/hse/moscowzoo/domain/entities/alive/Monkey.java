package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Monkey extends Herbo{
    private static final int DEFAULT_FOOD_CONSUMPTION = 5;

    public Monkey(int inventoryNumber, String name, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, DEFAULT_FOOD_CONSUMPTION, kindnessLevel);
    }
}
