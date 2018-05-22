package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;
import java.util.*;

public class LongestWordInDictionary implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new LongestWordInDictionary().runProgram();
    }

    @Override
    public void runProgram() {
        String[] dict = new String[] {
                "to",
                "toe",
                "toes",
                "doe",
                "dog",
                "god",
                "dogs",
                "book",
                "banana",
        };
        String input = "dsetog";
        System.out.println("OUTPUT: "+longestDictionary(dict,input));
    }

    private static List<String> longestDictionary(String[] dict, String input) {
        List<String> ret = new ArrayList<>();
        int maxLength = 0;

        for (String wrd : dict) {
            int len = wrd.length();
            if (len >= maxLength) {
                boolean match = true;
                for (char c : wrd.toCharArray()) {
                    match &= (input.indexOf(c) >= 0);
                }
                if (match) {
                    if (len > maxLength) {
                        ret.clear();
                        maxLength = len;
                    }
                    ret.add(wrd);
                }
            }
        }

        return ret;
    }
}
