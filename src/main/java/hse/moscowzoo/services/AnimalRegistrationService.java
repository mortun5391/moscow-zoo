package hse.moscowzoo.services;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalRegistrationService {
    private final AnimalRepository animalRepository;
    private final VeterinaryClinic veterinaryClinic;

    public AnimalRegistrationService(AnimalRepository animalRepository,
                                     VeterinaryClinic veterinaryClinic) {
        this.animalRepository = animalRepository;
        this.veterinaryClinic = veterinaryClinic;
    }

    public boolean registerAnimal(Animal animal) {
        if (veterinaryClinic.acceptAnimal(animal)) {
            animalRepository.save(animal);
            return true;
        }
        return false;
    }
}
