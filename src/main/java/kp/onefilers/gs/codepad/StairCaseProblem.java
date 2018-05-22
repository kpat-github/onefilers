package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class StairCaseProblem implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new StairCaseProblem().runProgram();
    }

    @Override
    public void runProgram() {
        int stairs = 9;
        System.out.println("Stairs combinations: "+fibonacci(stairs+1));
    }

    private int fibonacci(int pos) {
        int[] temp = new int[]{0,1};
        for (int i = 0; i < pos; i++) {
            temp[0] = temp[0] + temp[1];
            temp[1] = temp[0] - temp[1];
        }
        return temp[0];
    }
}
