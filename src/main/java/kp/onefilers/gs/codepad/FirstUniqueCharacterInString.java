package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class FirstUniqueCharacterInString implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new FirstUniqueCharacterInString().runProgram();
    }

    @Override
    public void runProgram() {
        String str = KpLearnUtils.readInput("Enter the input string:");
        System.out.println("firstUniqueCharacter = "+firstUniqueCharacter(str));
    }

    private Character firstUniqueCharacter(String str) {
        Set<Character> uniques = new LinkedHashSet<>();
        Set<Character> non_uniques = new HashSet<>();

        for (Character c : str.toCharArray()) {
            if (!non_uniques.contains(c)) {
                if (uniques.contains(c)) {
                    uniques.remove(c);
                    non_uniques.add(c);
                } else {
                    uniques.add(c);
                }
            }
        }
        return uniques.iterator().hasNext() ? uniques.iterator().next() : null;
    }

}
