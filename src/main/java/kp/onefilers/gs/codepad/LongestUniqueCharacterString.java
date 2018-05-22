package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class LongestUniqueCharacterString implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new LongestUniqueCharacterString().runProgram();
    }

    @Override
    public void runProgram() {
        String strInput = KpLearnUtils.readInput("Enter the text:");
        char[] charArr = strInput.toCharArray();

        int currIndex = 0, longestStrInd = 0;
        String currStr = "", longestSubStr = "";

        for (int i = 0; i < charArr.length; i++) {
            Character c = charArr[i];
            if (currStr.indexOf(c) >= 0) {
                i = currIndex + currStr.indexOf(c);
                currStr = "";
            } else {
                currIndex = ("".equals(currStr)) ? i : currIndex;
                currStr += c;
                if (currStr.length() > longestSubStr.length()) {
                    longestSubStr = currStr;
                    longestStrInd = currIndex;
                }
            }
        }

        System.out.println("Longest string of unique characters is: "
                +longestSubStr+" (position="+longestStrInd+", length="+longestSubStr.length()+")");
    }

}
