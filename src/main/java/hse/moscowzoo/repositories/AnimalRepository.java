package hse.moscowzoo.repositories;


import hse.moscowzoo.domain.entities.alive.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    void save(Animal animal);
    Optional<Animal> findById(int inventoryNumber);
    List<Animal> findAll();
    List<Animal> findContactZooEligible();
    int getTotalFoodConsumption();
}