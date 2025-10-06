package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;

public class Herbo extends Animal {
    private KindnessLevel kindnessLevel;

    public Herbo(int inventoryNumber, String name, int dailyFoodConsumption, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, dailyFoodConsumption);
        this.kindnessLevel = kindnessLevel;
    }

    @Override
    public boolean canBeInContactZoo() {
        return getKindnessLevel().isSuitableForContactZoo();
    }

    public KindnessLevel getKindnessLevel() {
        return kindnessLevel;
    }

    public void setKindnessLevel(KindnessLevel kindnessLevel) {
        this.kindnessLevel = kindnessLevel;
    }

}
