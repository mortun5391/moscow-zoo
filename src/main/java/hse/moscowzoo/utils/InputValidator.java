package hse.moscowzoo.utils;

import hse.moscowzoo.domain.valueobjects.KindnessLevel;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class InputValidator {
    private InputProvider inputProvider;

    public InputValidator(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }


    /**
     * Запрашивает у пользователя ввод целого числа и проверяет его корректность.
     *
     * @param prompt Сообщение, которое будет показано пользователю.
     * @return Целое число, введённое пользователем.
     */
    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return inputProvider.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
            } finally {
                inputProvider.nextLine(); // Очистка буфера после ввода
            }
        }
    }


    /**
     * Запрашивает у пользователя ввод строки и проверяет, что она не пустая.
     *
     * @param prompt Сообщение, которое будет показано пользователю.
     * @return Строка, введённая пользователем.
     */
    public String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = inputProvider.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Ошибка: ввод не может быть пустым.");
            }
        }
    }

    public KindnessLevel readKindnessLevel() {
        while (true) {
            int level = getIntInput("Уровень доброты (1-10): ");
            if (level >= 1 && level <= 10) {
                return KindnessLevel.of(level);
            }
            System.out.println("Ошибка: уровень доброты должен быть от 1 до 10!");
        }
    }


}
