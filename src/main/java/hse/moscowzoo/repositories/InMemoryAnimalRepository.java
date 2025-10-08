package hse.moscowzoo.repositories;

import hse.moscowzoo.domain.entities.alive.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAnimalRepository implements AnimalRepository{
    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void save(Animal animal) {
        animals.add(animal);
    }

    @Override
    public Optional<Animal> findById(int inventoryNumber) {
        return animals.stream()
                .filter(animal -> animal.getInventoryNumber() == inventoryNumber)
                .findFirst();
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(animals);
    }

    @Override
    public List<Animal> findContactZooEligible() {
        return animals.stream()
                .filter(Animal::canBeInContactZoo)
                .toList();
    }

    @Override
    public int getTotalFoodConsumption() {
        return animals.stream()
                .mapToInt(Animal::getDailyFoodConsumption)
                .sum();
    }
}
