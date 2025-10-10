package hse.moscowzoo.utils;

import hse.moscowzoo.domain.entities.alive.Animal;
import hse.moscowzoo.domain.interfaces.IInventory;
import hse.moscowzoo.domain.valueobjects.HealthStatus;
import org.springframework.stereotype.Component;



/**
 * Форматирование сообщений для вывода в консоль
 * Принцип SRP: только форматирование текста
 */
@Component
public class MessageFormatter {

    public String formatAnimalInfo(Animal animal) {
        return String.format("• %s (№%d) - %s, корм: %d кг/день, здоровье: %s%s",
                animal.getName(),
                animal.getInventoryNumber(),
                animal.getClass().getSimpleName(),
                animal.getDailyFoodConsumption(),
                formatHealthStatus(animal.getHealthStatus()),
                formatContactZooEligibility(animal.canBeInContactZoo())
        );
    }

    public String formatHealthStatus(HealthStatus isHealthy) {
        return isHealthy == HealthStatus.HEALTHY ? "✅ ЗДОРОВ" : "❌ БОЛЕН";
    }

    public String formatContactZooEligibility(boolean eligible) {
        return eligible ? " 🏠(контактный зоопарк)" : "";
    }

    public String formatInventoryItem(IInventory item) {
        return String.format("№%d - %s (%s)",
                item.getInventoryNumber(),
                item.getName(),
                item.getClass().getSimpleName()
        );
    }

    public String formatFoodReport(int animalCount, int totalFood) {
        return String.format("""
            📊 Отчет по кормам:
               Животных: %d
               Общее потребление: %d кг/день
               В среднем: %.1f кг/животное
            """, animalCount, totalFood, (double) totalFood / animalCount);
    }

    public String formatSuccess(String message) {
        return "✅ " + message;
    }

    public String formatError(String message) {
        return "❌ ОШИБКА: " + message;
    }

    public String formatInfo(String message) {
        return "ℹ️ " + message;
    }

    public String formatWarning(String message) {
        return "⚠️ " + message;
    }
}