package kp.onefilers.commons;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KpLearnUtils {

    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private static final Console console = System.console();
    private static final Scanner sc = new Scanner(System.in);

    public static <T> T readNextInput() {
        T input = null;
        sc.nextInt();
        return input;
    }

    public static String readInput(String message) {
        System.out.print(message);
        String input = null;
        if(console == null) {
            try {
                input = inputReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            input = console.readLine();
        }

        return input;
    }

    public static String numberPostFix (Integer i) {
        String ret = String.valueOf(i);
        if (ret.endsWith("1")) {
            ret += "st";
        } else if (ret.endsWith("2")) {
            ret += "nd";
        } else if (ret.endsWith("3")) {
            ret += "rd";
        } else {
            ret += "th";
        }
        return ret;
    }

    public static <T extends Object> String printArray(T[] array) {
        StringJoiner ret = new StringJoiner(", ");
        Arrays.asList(array).forEach(t -> ret.add(t.toString()));
        return "["+ret.toString()+"]";
    }
}
