package tesena.automation.training;

public class Utils {

    public static boolean compareStrings(String actual, String expected) {
        actual = modifyString(actual);
        expected = modifyString(expected);
        return actual.equalsIgnoreCase(expected);
    }

    private static String modifyString(String s) {
        s = s.replaceAll("\\s{2,}", "");
        s = s.replaceAll("\\r+", "");
        return s;
    }
}
