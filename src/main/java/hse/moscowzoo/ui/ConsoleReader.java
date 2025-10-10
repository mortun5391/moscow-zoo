package hse.moscowzoo.ui;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;
import hse.moscowzoo.utils.InputValidator;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;
    private final InputValidator validator;

    public ConsoleReader(InputValidator validator) {
        this.scanner = new Scanner(System.in);
        this.validator = validator;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public String readValidatedName(String prompt) {
        while (true) {
            String name = readString(prompt);
            try {
                return validator.validateAndFormatName(name);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Ошибка: введите целое число!");
            }
        }
    }

    public int readValidatedInventoryNumber(String prompt) {
        while (true) {
            int number = readInt(prompt);
            if (validator.isValidInventoryNumber(number)) {
                return number;
            }
            System.out.println("❌ Ошибка: инвентарный номер должен быть от 1 до 9999!");
        }
    }

    public KindnessLevel readKindnessLevel() {
        while (true) {
            int level = readInt("Уровень доброты (1-10): ");
            if (validator.isValidKindnessLevel(level)) {
                return KindnessLevel.of(level);
            }
            System.out.println("❌ Ошибка: уровень доброты должен быть от 1 до 10!");
        }
    }

    public int readMenuChoice() {
        while (true) {
            int choice = readInt("Выберите пункт меню: ");
            if (validator.isValidMenuChoice(choice)) {
                return choice;
            }
            System.out.println("❌ Ошибка: выберите пункт от 0 до 5!");
        }
    }

    public int readAnimalTypeChoice() {
        while (true) {
            int choice = readInt("Выберите тип животного: ");
            if (validator.isValidAnimalTypeChoice(choice)) {
                return choice;
            }
            System.out.println("❌ Ошибка: выберите тип от 1 до 4!");
        }
    }

    public boolean readConfirmation(String prompt) {
        while (true) {
            String input = readString(prompt + " (да/нет): ").toLowerCase();
            if (input.equals("да") || input.equals("д") || input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("нет") || input.equals("н") || input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("❌ Ошибка: введите 'да' или 'нет'!");
        }
    }
}
