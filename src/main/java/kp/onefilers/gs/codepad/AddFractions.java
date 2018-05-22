package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class AddFractions implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
//        new AddFractions().runProgram();
        System.out.println(gcd(12*24*36,16));
    }

    @Override
    public void runProgram() {
        String fracStr = KpLearnUtils.readInput("Enter fractions separated by , : a/b,c/d,...,x/y");
        String[] fracArr = fracStr.split(",");
        int fractions = fracArr.length;
        int[] numerators = new int[fractions];
        int[] denominators = new int[fractions];
        int pos = 0;
        for (String frac : fracArr) {
            String[] parts = frac.trim().split("/");
            int[] norm = gcdNorm(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            numerators[pos] = norm[0];
            denominators[pos] = norm[1];
            pos++;
        }

        int[] addRes = add(numerators, denominators);
        String den = (addRes[1] == 1)?"":("/"+String.valueOf(addRes[1]));
        System.out.println("Addition result = "+String.valueOf(addRes[0])+den);
    }

    private int[] add(int[] numerators, int[] denominators) {
        int num = 0;
        int den = 1;
        for (int numPos = 0; numPos < numerators.length; numPos++) {
            for (int denPos = 0; denPos < denominators.length; denPos++) {
                if (numPos == 0) {
                    den *= denominators[denPos];
                }
                if (numPos != denPos) {
                    numerators[numPos] *= denominators[denPos];
                }
            }
            num += numerators[numPos];
        }

        return gcdNorm(num, den);
    }

    private int[] gcdNorm(int num, int den) {
        int[] ret = new int[]{num,den};
        int gcd = gcd(num, den);
        ret[0] = num/gcd;
        ret[1] = den/gcd;
        return ret;
    }

    static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 1;

        while (a != b) {
            while (a > b) {
                a = a - b;
            }
            while (b > a) {
                b = b - a;
            }
        }

        return a;
    }

    static int gcd_recursive(int a, int b) {
        if (a == 0 || b == 0)
            return 1;

        if (a == b)
            return a;

        a = (a>b) ? a-b : a;
        b = (b>a) ? b-a : b;

        return gcd_recursive(a, b);
    }
}
