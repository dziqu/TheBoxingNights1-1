package pl.theboxingnights.app.others.comparator;

/**
 * Created by filip / 13.06.15 / 20:05
 */
public class Comparator {

    public static boolean compare(Float x, SimpleFloatComparator simpleFloatComparator) {
        return simpleFloatComparator.compare(x);
    }

    public static boolean compare(Float x, Float y, FloatComparator floatComparator) {
        return floatComparator.compare(x, y);
    }

    public static boolean compare (Boolean x, SimpleBooleanComparator simpleBooleanComparator) {
        return simpleBooleanComparator.compare(x);
    }

    public static boolean compare(Boolean x, Boolean y, DoubleBooleanComparator doubleBooleanComparator) {
        return doubleBooleanComparator.compare(x, y);
    }

    public static boolean compare(String s1, String s2,  StringComparator stringComparator) {
        return stringComparator.compare(s1, s2);
    }
}
