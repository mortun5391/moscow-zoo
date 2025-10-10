package hse.moscowzoo.services;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.interfaces.IInventory;
import hse.moscowzoo.repositories.AnimalRepository;
import hse.moscowzoo.repositories.ThingsRepository;

import java.util.ArrayList;
import java.util.List;

public class ZooInventoryService {
    private final AnimalRepository animalRepository;
    private final ThingsRepository thingsRepository;

    public ZooInventoryService(AnimalRepository animalRepository, ThingsRepository thingsRepository) {
        this.animalRepository = animalRepository;
        this.thingsRepository = thingsRepository;
    }

    public List<IInventory> getAllInventory() {
        List<IInventory> inventory = new ArrayList<>();
        inventory.addAll(animalRepository.findAll());
        inventory.addAll(thingsRepository.findAll());
        return inventory;
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }
}
