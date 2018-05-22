package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class PrimeFactors implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new PrimeFactors().runProgram();
    }

    @Override
    public void runProgram() {
        int input = 233454;
        System.out.println(String.format("Prime factors of %d are: ",input)+primeFactors(input));
    }

    private List<Integer> primeFactors(int num) {
        List<Integer> pfs = new LinkedList<>();
        int factor = 2, temp = num;
        while(factor <= temp) {
            if (temp%factor == 0) {
                pfs.add(factor);
                temp /= factor;
            } else {
                factor++;
            }
        }
        if (pfs.get(0).equals(num)) {
            pfs.add(1);
        }
        return pfs;
    }
}
