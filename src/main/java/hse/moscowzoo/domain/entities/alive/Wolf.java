package hse.moscowzoo.domain.entities.alive;


public class Wolf extends Predator{
    private static final int DEFAULT_FOOD_CONSUMPTION = 3;

    public Wolf(int inventoryNumber, String name) {
        super(inventoryNumber, name, DEFAULT_FOOD_CONSUMPTION);
    }
}
