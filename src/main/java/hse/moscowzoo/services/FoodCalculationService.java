package hse.moscowzoo.services;

import hse.moscowzoo.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodCalculationService {
    private final AnimalRepository animalRepository;

    public FoodCalculationService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public int calculateTotalFoodConsumption() {
        return animalRepository.getTotalFoodConsumption();
    }

    public int getAnimalCount() {
        return animalRepository.findAll().size();
    }
}
