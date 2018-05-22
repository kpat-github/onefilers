package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class BiggestNumberFromListOfNumbers implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new BiggestNumberFromListOfNumbers().runProgram();
    }

    @Override
    public void runProgram() {
        int[] input = new int[]{1,34,3,98,9,76,45,4};
        ArrayList<String> list = new ArrayList<>();
        String number = "";
        for (int num : input) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new NumberComparator());
        for (String str : list) {
            number += str;
        }
        System.out.println(number);
    }

    class NumberComparator implements Comparator<String> {
        @Override
        public int compare(String i1, String i2) {
            String orig = i1 + "" + i2;
            String reverse = i2 + "" + i1;
            return reverse.compareTo(orig);
        }
    }
}
