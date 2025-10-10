package hse.moscowzoo.services;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactZooService {
    private final AnimalRepository animalRepository;

    public ContactZooService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getContactZooAnimals() {
        return animalRepository.findContactZooEligible();
    }
}
