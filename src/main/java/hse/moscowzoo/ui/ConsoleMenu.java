package hse.moscowzoo.ui;

import hse.moscowzoo.domain.entities.alive.*;
import hse.moscowzoo.services.AnimalRegistrationService;
import hse.moscowzoo.services.ContactZooService;
import hse.moscowzoo.services.FoodCalculationService;
import hse.moscowzoo.services.ZooInventoryService;
import hse.moscowzoo.utils.InputValidator;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMenu {
    private final ConsolePrinter printer;
    private final InputValidator inputValidator;
    private final AnimalRegistrationService registrationService;
    private final FoodCalculationService foodService;
    private final ContactZooService contactZooService;
    private final ZooInventoryService inventoryService;

    public ConsoleMenu(ConsolePrinter printer,InputValidator inputValidator, AnimalRegistrationService registrationService,
                       FoodCalculationService foodService, ContactZooService contactZooService, ZooInventoryService inventoryService) {
        this.printer = printer;
        this.inputValidator = inputValidator;
        this.registrationService = registrationService;
        this.foodService = foodService;
        this.contactZooService = contactZooService;
        this.inventoryService = inventoryService;
    }



    public void showMainMenu() {
        while (true) {
            printer.printMainMenu();
            int choice = inputValidator.getIntInput("Choose item: ");

            switch (choice) {
                case 1 -> addAnimal();
                case 2 -> showAllAnimals();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Wrong menu item!");
            }
        }
    }

    private void addAnimal() {
        System.out.println("\n--- Adding animal ---");

        try {
            String name = inputValidator.getStringInput("Animal`s name: ");
            int inventoryNumber = inputValidator.getIntInput("Inventory number: ");

            printer.printAnimalTypesMenu();
            int type = inputValidator.getIntInput("Choose type: ");

            Animal animal = switch (type) {
                case 1 -> new Rabbit(inventoryNumber, name, inputValidator.readKindnessLevel());
                case 2 -> new Monkey(inventoryNumber, name, inputValidator.readKindnessLevel());
                case 3 -> new Tiger(inventoryNumber, name);
                case 4 -> new Wolf(inventoryNumber, name);
                default -> throw new IllegalArgumentException("Wrong animal type");
            };

            boolean accepted = registrationService.registerAnimal(animal);
            printer.printAnimalAdded(animal, accepted);

        } catch (Exception e) {
            System.out.println("Error when adding an animal: " + e.getMessage());
        }
    }

    private void showAllAnimals() {
        try {
            printer.printAnimals(inventoryService.getAnimals());
        } catch (Exception e) {
            System.out.println("Error when showing animals: " + e.getMessage());
        }
    }
}

