package hse.moscowzoo.domain.entities.alive;


public abstract class Predator extends Animal{
    public Predator(int inventoryNumber, String name, int dailyFoodConsumption) {
        super(inventoryNumber, name, dailyFoodConsumption);
    }

    @Override
    public boolean canBeInContactZoo() {
        return false;
    }

}
