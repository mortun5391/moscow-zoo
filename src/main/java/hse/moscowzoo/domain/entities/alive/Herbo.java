package hse.moscowzoo.domain.entities.alive;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class Herbo extends Animal {
    @Getter
    @Setter
    private KindnessLevel kindnessLevel;

    public Herbo(int inventoryNumber, String name, int dailyFoodConsumption, KindnessLevel kindnessLevel) {
        super(inventoryNumber, name, dailyFoodConsumption);
        this.kindnessLevel = kindnessLevel;
    }

    @Override
    public boolean canBeInContactZoo() {
        return getKindnessLevel().isSuitableForContactZoo();
    }


}
