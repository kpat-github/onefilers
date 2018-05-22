package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class LongestPalindrome implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new LongestPalindrome().runProgram();
    }

    @Override
    public void runProgram() {
        String inputStr = KpLearnUtils.readInput("Enter the string:");
        Set<String> longestPalindromes = new HashSet<String>();
        Deque<String> dequePal = new ArrayDeque<>();
        dequePal.addFirst(inputStr);

//        This set is used to filter out duplicates, for performance (95% above improvements in worst cases)
//        Set<String> duplicate = new HashSet<>();
//        int len = inputStr.length();
        while (!dequePal.isEmpty()) {
            String first = dequePal.pollFirst();
//            if (len > first.length()) {
//                //clearing the duplicate set as one length iteration is done.
//                duplicate.clear();
//                len = first.length();
//            }
            if (isPalindrome(first)) {
                //palindrome found, so go through rest of the same length cases to find others, and then break.
                longestPalindromes.add(first);
                if (dequePal.size() > 0) {
                    for (String str = dequePal.pollFirst();
                         str != null && first.length() == str.length();
                         str = dequePal.pollFirst()) {
                        if (isPalindrome(str)) {
                            longestPalindromes.add(new String(str));
                        }
                    }
                }
                break;
            } else {
                String[] strArr = new String[] {first.substring(1,first.length()), first.substring(0,first.length()-1)};
                for (String str : strArr) {
                    //add substring cases for next level to be scanned for palindromes, duplicates are getting avoided here.
//                    if (!duplicate.contains(str)) {
                        dequePal.addLast(str);
//                        duplicate.add(str);
//                    }
                }
            }
        }

        System.out.println("Longest palindromes found are:");
        System.out.println(longestPalindromes);
    }

    private boolean isPalindrome(String checkStr) {
        StringBuilder sb = new StringBuilder(checkStr);
        return (checkStr == null) ? false : checkStr.equals(sb.reverse().toString());
    }

}
