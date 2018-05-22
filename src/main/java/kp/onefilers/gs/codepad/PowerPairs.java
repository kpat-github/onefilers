package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class PowerPairs implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new PowerPairs().runProgram();
    }

    @Override
    public void runProgram() {
        int[] x = { 1, 2, 3, 5, 4 };
        int[] y = { 2, 4, 6, 9, 3 };

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (pow(x[i], y[j]) == pow(y[j], x[i])) {
                    System.out.println("(" + x[i] + "," + y[j] + ") and (" + y[j] + "," + x[i] + ")");
                }
            }
        }
    }

    private static int pow(int a, int b) {
        return Double.valueOf(Math.pow(a, b)).intValue();
    }
}
