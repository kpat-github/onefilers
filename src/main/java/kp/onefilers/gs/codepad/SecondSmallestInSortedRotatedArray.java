package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class SecondSmallestInSortedRotatedArray implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new SecondSmallestInSortedRotatedArray().runProgram();
    }

    @Override
    public void runProgram() {
        Integer[][] sortedRotatedArrays = new Integer[][] {
                {1,2,3,4,5,6,7,8,9}, //Case 1 : border case
                {9,1,2,3,4,5,6,7,8}, //Case 2 : border case
                {2,3,4,5,6,7,8,9,1}, //Case 3 : border case
                {7,8,9,1,2,3,4,5,6}, //Case 4 : normal case
        };
        // This is for 2nd smallest, we can give 3rd, 4th ... (any)
        int smallest = 21;
        for (Integer[] arr : sortedRotatedArrays) {
            System.out.println("Input array: "+KpLearnUtils.printArray(arr));
            for (int i = 0; i < arr.length; i++) {
//                int pos = i%arr.length;
//                int posNext = (i+1)%arr.length;
                int pos = i;
                int posNext = ((i+1) == arr.length) ? 0 : i+1;
                if (arr[pos] > arr[posNext]) {
                    System.out.println(KpLearnUtils.numberPostFix(smallest)+" smallest: "
                            +arr[(pos+smallest)%arr.length]
                            +". Found in iterations: "+i);
                    break;
                }
            }
        }
    }
}
