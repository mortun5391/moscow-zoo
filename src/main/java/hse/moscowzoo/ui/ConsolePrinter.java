package hse.moscowzoo.ui;

import hse.moscowzoo.domain.entities.alive.Animal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsolePrinter {

    public void printMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("       MOSCOW ZOO");
        System.out.println("=".repeat(40));
        System.out.println("1. Add animal");
        System.out.println("2. Show all animals");
        System.out.println("0. Exit");
        System.out.println("-".repeat(40));
    }

    public void printAnimalTypesMenu() {
        System.out.println("\n--- Choose type of animal ---");
        System.out.println("1. Rabbit");
        System.out.println("2. Monkey");
        System.out.println("3. Tiger");
        System.out.println("4. Wolf");
    }

    public void printAnimalAdded(Animal animal, boolean accepted) {
        System.out.println("\n--- Registration result ---");
        System.out.println("Animal: " + animal.getName());
        System.out.println("Inventory name: " + animal.getInventoryNumber());
        System.out.println("Agreed in zoo: " + (accepted ? "YES" : "NO"));
    }

    public void printAnimals(List<Animal> animals) {
        System.out.println("\n--- All animals ---");
        if (animals.isEmpty()) {
            System.out.println("No animals in zoo");
        } else {
            for (Animal animal : animals) {
                System.out.println("- " + animal.getName() +
                        " (№" + animal.getInventoryNumber() + ") - " +
                        animal.getClass().getSimpleName());
            }
        }
    }
}