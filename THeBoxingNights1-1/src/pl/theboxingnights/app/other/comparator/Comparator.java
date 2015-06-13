package pl.theboxingnights.app.other.comparator;

import java.util.function.BooleanSupplier;

/**
 * Created by filip / 13.06.15 / 20:05
 */
public class Comparator {

    public static boolean compare(Float x, Float y, FloatComparator floatComparator) {
        return floatComparator.compare(x, y);
    }

    public static boolean compare(Boolean x, Boolean y, BooleanComparator booleanComparator) {
        return booleanComparator.compare(x, y);
    }

    public static boolean compare(String s1, String s2,  StringComparator stringComparator) {
        return stringComparator.compare(s1, s2);
    }
}
