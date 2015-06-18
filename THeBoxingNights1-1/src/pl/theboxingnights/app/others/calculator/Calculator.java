package pl.theboxingnights.app.others.calculator;

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

    public static Double calculate(DoubleCalculator doubleCalculator, Double x, Double y) {
        return doubleCalculator.calculate(x, y);
    }
}
