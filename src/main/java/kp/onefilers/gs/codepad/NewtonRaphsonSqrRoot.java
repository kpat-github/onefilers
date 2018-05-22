package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class NewtonRaphsonSqrRoot implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new NewtonRaphsonSqrRoot().runProgram();
    }

    @Override
    public void runProgram() {
        Double input = 144.0;
        Double currEst = input / 2.0;
        Double newEst = null;

        while(true) {
            newEst = newEstimate(currEst,input);
            if (Math.abs(currEst-newEst) < 0.000000001) {
                System.out.println(String.format("The square-root of %f is %f", input, currEst));
                return;
            } else {
                currEst = newEst;
            }
        }

    }

    private Double newEstimate(Double currEst, Double num) {
        return currEst - ((currEst* currEst -  num)/(2*currEst));
    }
}
