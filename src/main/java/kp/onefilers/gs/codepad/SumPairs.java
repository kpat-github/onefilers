package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class SumPairs implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new SumPairs().runProgram();
    }

    @Override
    public void runProgram() {
        int sum = 12;
        int[] input = new int[]{6,0,12,6,5,4,7};
        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            int diff = sum - i;
            if (diff >= 0) {
                if (!set.contains(diff)) {
                    set.add(i);
                } else {
                    System.out.println("Found a pair: (" + diff + "," + i + ")");
                }
            }
        }
    }
}
