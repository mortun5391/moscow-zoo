package hse.moscowzoo.repositories;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.entities.things.Thing;

import java.util.List;
import java.util.Optional;

public interface ThingsRepository {
    void save(Thing thing);
    Optional<Thing> findById(int inventoryNumber);
    List<Thing> findAll();
}
