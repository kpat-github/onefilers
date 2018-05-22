package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class MinimumSubArrayExceedingSum implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new MinimumSubArrayExceedingSum().runProgram();
    }

    @Override
    public void runProgram() {
        Integer[] input = new Integer[]{1,2,3,4,6,7};
        int sum = 10;
        for (int i = 0; i < input.length; i++) {
            int sumSubArray = 0;
            for (int j = 0; j < input.length - i; j++) {
                for (int k = 0; k <= i; k++) {
                    sumSubArray += input[j + k];
                }
                if (sumSubArray == sum) {
                    System.out.println(String.format(
                            "The minimum sub-array with sum %d is of length %d start index %d", sum, i+1, j));
                    return;
                }
                sumSubArray = 0;
            }
        }
        System.out.println(String.format("No sub-array with sum %d",sum));
    }
}
