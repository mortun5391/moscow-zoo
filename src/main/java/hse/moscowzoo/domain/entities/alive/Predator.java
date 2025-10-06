package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Predator extends Animal{
    public Predator(int inventoryNumber, String name, int dailyFoodConsumption, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, dailyFoodConsumption);
    }

    @Override
    public boolean canBeInContactZoo() {
        return false;
    }

}
