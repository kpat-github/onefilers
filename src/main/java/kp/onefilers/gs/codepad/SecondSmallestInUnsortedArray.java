package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class SecondSmallestInUnsortedArray implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new SecondSmallestInUnsortedArray().runProgram();
    }

    @Override
    public void runProgram() {
        Integer[] unsortedArr = new Integer[]{3,7,5,1,9,6,8};
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        if (unsortedArr.length < 2) {
            System.out.println(" Invalid Input ");
            System.exit(0);
        }

        for (int currElement : unsortedArr) {
            if (currElement < smallest) {
                secondSmallest = smallest;
                smallest = currElement;
            } else if (currElement < secondSmallest && currElement != smallest)
                secondSmallest = currElement;
        }
        System.out.println("Second smallest: "+secondSmallest);
    }
}
