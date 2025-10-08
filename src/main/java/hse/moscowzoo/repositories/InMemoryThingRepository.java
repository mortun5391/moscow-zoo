package hse.moscowzoo.repositories;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.entities.things.Thing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryThingRepository implements ThingsRepository {
    private final List<Thing> things = new ArrayList<>();

    @Override
    public void save(Thing thing) {
        things.add(thing);
    }

    @Override
    public Optional<Thing> findById(int inventoryNumber) {
        return things.stream()
                .filter(thing -> thing.getInventoryNumber() == inventoryNumber)
                .findFirst();
    }

    @Override
    public List<Thing> findAll() {
        return new ArrayList<>(things);
    }
}
