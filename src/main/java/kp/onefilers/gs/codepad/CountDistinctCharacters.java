package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class CountDistinctCharacters implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new CountDistinctCharacters().runProgram();
    }

    @Override
    public void runProgram() {
        String strIn = "AAASSSDDDEDDDDEEEESSSSSFFFFRRRTTTGGGGGSSSDSGGGGTTT!...";
        final Map<Character,Integer> countMap = new TreeMap<>();
        for (char c : strIn.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c)+1);
            } else {
                countMap.put(c, 1);
            }
        }
        final StringJoiner sj = new StringJoiner("~");
        countMap.forEach((k,v) -> sj.add(""+v+k));
        System.out.println("Output: "+sj.toString());
    }
}
