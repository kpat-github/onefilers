package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class LongestFirstRepeatingCharacters implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new LongestFirstRepeatingCharacters().runProgram();
    }

    @Override
    public void runProgram() {
        char[] ch = "aaabbbbccdddde".toCharArray();
        int[] output = new int[]{0,0};
        for (int i = 0; i < ch.length;) {
            char c = ch[i];
            int count = 0;
            int ind = i;
            while (i < ch.length && c == ch[i]) {
                count++;
                i++;
            }
            if (count > output[0]) {
                output[0] = count;
                output[1] = ind;
            }
        }
        System.out.println("Output: "+output);
    }
}
