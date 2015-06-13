package pl.theboxingnights.app.other;

/**
 * Created by filip / 13.06.15 / 17:37
 */
public class Calculator {

    public static Float calculate(FloatCalculator floatCalculator, Float x, Float y) {
        return floatCalculator.calculate(x, y);
    }

    public static Integer calculate(IntCalculator intCalculator, Integer x, Integer y) {
        return intCalculator.calculate(x, y);
    }
}