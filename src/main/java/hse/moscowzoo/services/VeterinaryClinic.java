package hse.moscowzoo.services;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.valueobjects.HealthStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VeterinaryClinic {
    private final Random random = new Random();

    public boolean examineAnimal(Animal animal) {
        boolean isHealthy = random.nextDouble() < 0.8;
        animal.setHealthStatus(isHealthy ? HealthStatus.HEALTHY : HealthStatus.SICK);
        return isHealthy;
    }

    public boolean acceptAnimal(Animal animal) {
        return examineAnimal(animal);
    }
}
