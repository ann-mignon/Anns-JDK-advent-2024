package aoc24;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Util {
    public static void putln(Object o) {
        System.out.println(o);
    }

    public static String[] splitta(String str, String delim) {
        List<String> ut = Arrays.stream(str.split(delim)).map(String::trim).toList();
        return ut.toArray(new String[0]);
    }

    public static int[] toIntArray(String[] strings) {
        return Arrays.stream(strings).map(Integer::parseInt).mapToInt(Integer::valueOf).toArray();
    }

    public static List<Integer> toIntegerList(String[] strings) {
        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static String kaka() {
        return getProperty("pepparkaka");
    }

    public static String getProperty(String key) {
        try (InputStream propFile = AOC.class.getClassLoader().getResourceAsStream("aoc.properties")) {
            Properties prop = new Properties();
            prop.load(propFile);
            return prop.getProperty(key);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
