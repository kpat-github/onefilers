package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

import java.io.*;

public class Fibonacci implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) throws IOException {
        new Fibonacci().runProgram();
    }

    @Override
    public void runProgram() {
        String inputPos = KpLearnUtils.readInput("Enter the fibonacci position: ");
        int pos = Integer.parseInt(inputPos);
        System.out.println("fibonacciIterative = " + fibonacciIterativeVar(pos));
        System.out.println("fibonacciRecursive = " + fibonacciRecursive(pos));
    }

    private long fibonacciIterative(int pos) {
        long[] temp = new long[]{0,1};
        for (int i = 0; i < pos; i++) {
            temp[0] = temp[0] + temp[1];
            temp[1] = temp[0] - temp[1];
        }
        return temp[0];
    }

    private long fibonacciIterativeVar(int pos) {
        if (pos < 2) {
            return pos;
        }
        long prev = 0, next = 1;
        for (int i = 0; i < pos-1; i++) {
            next = next + prev;
            prev = next - prev;
        }
        return next;
    }

    private long fibonacciRecursive(int pos) {
        if (pos < 2) {
            return pos;
        }
        long fib = fibonacciRecursive(pos-1) + fibonacciRecursive(pos-2);
        return fib;
    }

}
