package hse.moscowzoo.domain.valueobjects;

public class KindnessLevel {
    private final int value;

    private KindnessLevel(int value) {
        if (value < 1 || value > 10) {
            throw new IllegalArgumentException("Уровень доброты должен быть от 1 до 10");
        }
        this.value = value;
    }

    public static KindnessLevel of(int value) {
        return new KindnessLevel(value);
    }

    public static KindnessLevel defaultLevel() {
        return new KindnessLevel(5);
    }

    public int getValue() {
        return value;
    }

    public boolean isSuitableForContactZoo() {
        return value > 5;
    }


}
