package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class PangramsMissingCharacters implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new PangramsMissingCharacters().runProgram();
    }

    @Override
    public void runProgram() {
        boolean[] alpha = new boolean[26];
        String strInput = "Kshitij pandey ...";

        for (char c : strInput.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
               alpha[c-'a'] = true;
            }
        }
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < alpha.length; i++) {
            if (!alpha[i]) {
                sj.add(String.valueOf((char)('a'+i)));
            }
        }
        System.out.println("Output: "+sj.toString());
    }
}
