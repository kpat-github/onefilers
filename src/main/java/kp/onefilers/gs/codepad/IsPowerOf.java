package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class IsPowerOf implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new IsPowerOf().runProgram();
    }

    @Override
    public void runProgram() {
        //Finds out if x is a power of y
        double x = 0.25, y = 2, n=0;

        if (x < y) {
            n = 1/y;
            while (x < n) {
                n /= y;
            }
        } else {
            n = y;
            while (x > n) {
                n *= y;
            }
        }
        System.out.println(x+" is a power of "+y+" : "+(x==n));
    }
}
