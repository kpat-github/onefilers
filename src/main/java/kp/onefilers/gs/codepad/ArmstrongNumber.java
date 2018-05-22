package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class ArmstrongNumber implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new ArmstrongNumber().runProgram();
    }

    @Override
    public void runProgram() {
        int[] input = new int[]{121,371,407,999};
        for (int in : input) {
            int num = in, sum = 0, temp = 0;
            while (num > 0) {
                temp = num % 10;
                num /= 10;
                sum += Double.valueOf(Math.pow(temp, 3)).intValue();
            }
            System.out.println(String.format("%d is Armstrong number: %b", in, (in == sum)));
        }
    }
}
