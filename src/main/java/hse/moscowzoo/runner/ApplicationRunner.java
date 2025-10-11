package hse.moscowzoo.runner;

import hse.moscowzoo.ui.ConsoleMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final ConsoleMenu consoleMenu;

    public ApplicationRunner(ConsoleMenu consoleMenu) {
        this.consoleMenu = consoleMenu;
    }

    @Override
    public void run(String... args) {
        System.out.println("Запуск Московского зоопарка...");
        consoleMenu.showMainMenu();
    }
}