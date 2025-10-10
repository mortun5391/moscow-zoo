package hse.moscowzoo.ui;

import hse.moscowzoo.domain.entities.alive.*;
import hse.moscowzoo.services.AnimalRegistrationService;
import hse.moscowzoo.services.ContactZooService;
import hse.moscowzoo.services.FoodCalculationService;
import hse.moscowzoo.services.ZooInventoryService;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMenu {
    private final ConsolePrinter printer;
    private final ConsoleReader reader;
    private final AnimalRegistrationService registrationService;
    private final FoodCalculationService foodService;
    private final ContactZooService contactZooService;
    private final ZooInventoryService inventoryService;

    public ConsoleMenu(ConsolePrinter printer, ConsoleReader reader, AnimalRegistrationService registrationService,
                       FoodCalculationService foodService, ContactZooService contactZooService, ZooInventoryService inventoryService) {
        this.printer = printer;
        this.reader = reader;
        this.registrationService = registrationService;
        this.foodService = foodService;
        this.contactZooService = contactZooService;
        this.inventoryService = inventoryService;
    }


    public void showMainMenu() {
        while (true) {
            printer.printMainMenu();
            int choice = reader.readInt("Выберите пункт: ");

            switch (choice) {
                case 1 -> addAnimal();
                case 2 -> showAllAnimals();
                //case 3 -> calculateFood();
                //case 4 -> showContactZooAnimals();        TODO
                //case 5 -> showInventory();
                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("❌ Неверный пункт меню!");
            }
        }
    }

    private void addAnimal() {
        System.out.println("\n--- Добавление животного ---");
        String name = reader.readString("Имя животного: ");
        int inventoryNumber = reader.readInt("Инвентарный номер: ");

        printer.printAnimalTypesMenu();

        int type = reader.readInt("Выберите тип: ");

        Animal animal = switch (type) {
            case 1 -> new Rabbit(inventoryNumber, name, reader.readKindnessLevel());
            case 2 -> new Monkey(inventoryNumber, name, reader.readKindnessLevel());
            case 3 -> new Tiger(inventoryNumber, name);
            case 4 -> new Wolf(inventoryNumber, name);
            default -> throw new IllegalArgumentException("Неверный тип животного");
        };

        boolean accepted = registrationService.registerAnimal(animal);
        printer.printAnimalAdded(animal, accepted);
    }

    private void showAllAnimals() {
        printer.printAnimals(inventoryService.getAnimals());
    }
}
