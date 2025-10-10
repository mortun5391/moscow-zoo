package hse.moscowzoo.ui;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.interfaces.IInventory;
import hse.moscowzoo.utils.MessageFormatter;

import java.util.List;

public class ConsolePrinter {
    private final MessageFormatter formatter;

    public ConsolePrinter(MessageFormatter formatter) {
        this.formatter = formatter;
    }

    public void printMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏠           МОСКОВСКИЙ ЗООПАРК");
        System.out.println("=".repeat(50));
        System.out.println("1. 🐾 Добавить животное");
        System.out.println("2. 📋 Показать всех животных");
        System.out.println("3. 🥕 Рассчитать потребление корма");
        System.out.println("4. 🏠 Животные для контактного зоопарка");
        System.out.println("5. 📦 Инвентаризация");
        System.out.println("0. 🚪 Выход");
        System.out.println("-".repeat(50));
    }

    public void printAnimalTypesMenu() {
        System.out.println("\n--- Выбор типа животного ---");
        System.out.println("1. 🐇 Кролик");
        System.out.println("2. 🐵 Обезьяна");
        System.out.println("3. 🐯 Тигр");
        System.out.println("4. 🐺 Волк");
    }

    public void printAnimalAdded(Animal animal, boolean accepted) {
        System.out.println("\n--- Результат регистрации ---");
        System.out.println(formatter.formatAnimalInfo(animal));
        if (accepted) {
            printSuccess("Животное принято в зоопарк! 🎉");
        } else {
            printError("Животное не принято в зоопарк ❌");
        }
    }

    public void printAnimals(List<Animal> animals) {
        System.out.println("\n--- Все животные ---");
        if (animals.isEmpty()) {
            printInfo("Нет животных в зоопарке");
        } else {
            animals.forEach(animal ->
                    System.out.println(formatter.formatAnimalInfo(animal))
            );
        }
    }

    public void printContactZooAnimals(List<Animal> animals) {
        System.out.println("\n--- Контактный зоопарк ---");
        if (animals.isEmpty()) {
            printInfo("Нет животных для контактного зоопарка");
        } else {
            animals.forEach(animal ->
                    System.out.println(formatter.formatAnimalInfo(animal))
            );
        }
    }

    public void printFoodReport(int animalCount, int totalFood) {
        System.out.println(formatter.formatFoodReport(animalCount, totalFood));
    }

    public void printInventory(List<IInventory> inventory) {
        System.out.println("\n--- Инвентаризация ---");
        if (inventory.isEmpty()) {
            printInfo("Нет объектов в инвентаре");
        } else {
            inventory.forEach(item ->
                    System.out.println("• " + formatter.formatInventoryItem(item))
            );
        }
    }

    public void printSuccess(String message) {
        System.out.println(formatter.formatSuccess(message));
    }

    public void printError(String message) {
        System.out.println(formatter.formatError(message));
    }

    public void printInfo(String message) {
        System.out.println(formatter.formatInfo(message));
    }

    public void printWarning(String message) {
        System.out.println(formatter.formatWarning(message));
    }
}
