package hse.moscowzoo.utils;

public class InputValidator {
    public boolean isValidName(String name) {
        return name != null &&
                !name.trim().isEmpty() &&
                name.length() >= 2 &&
                name.length() <= 50 &&
                name.matches("[a-zA-Zа-яА-ЯёЁ0-9\\s]+");
    }

    public boolean isValidInventoryNumber(int number) {
        return number > 0 && number <= 9999;
    }

    public boolean isValidKindnessLevel(int level) {
        return level >= 1 && level <= 10;
    }

    public boolean isValidFoodConsumption(int food) {
        return food > 0 && food <= 100; // максимум 100 кг в день
    }

    public boolean isValidAnimalTypeChoice(int choice) {
        return choice >= 1 && choice <= 4; // 1-4 типы животных
    }

    public boolean isValidMenuChoice(int choice) {
        return choice >= 0 && choice <= 5; // 0-5 пункты меню
    }

    public String validateAndFormatName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException(
                    "Имя должно содержать 2-50 символов (буквы, цифры, пробелы)");
        }
        return name.trim();
    }
}
