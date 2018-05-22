package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class Anagrams implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new Anagrams().runProgram();
    }

    @Override
    public void runProgram() {
        String inStr = KpLearnUtils.readInput("Enter the text for anagram search");
        String[] inStrArr = inStr.split(" ");
        int startPos = 0;
        Map<String,Set<String>> anagramsMap = new HashMap<>();
        for (String s: inStrArr) {
            char[] chars = s.trim().toLowerCase().toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new HashSet<String>());
            }
            anagramsMap.get(key).add(s);
        }

        System.out.println("Anagrams in: "+inStr);
        for (Set<String> l : anagramsMap.values()) {
            System.out.println(l);
        }
    }
}
