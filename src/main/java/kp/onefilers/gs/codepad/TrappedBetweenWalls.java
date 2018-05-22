package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class TrappedBetweenWalls implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new TrappedBetweenWalls().runProgram();
    }

    @Override
    public void runProgram() {
        Integer[][] inputs = new Integer[][]{
                {3, 2, 1, 4, 3, 2, 4}, // 6
                {3, 2, 1, 4, 3, 2, 1}, // 3
                {1, 2, 3, 0, 3, 4}, // 3
                {4, 5, 6, 5, 4}, // 0
                {6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6}, // 36
                {9,7,0,7,6,0,6,5,0,5,4,0,4,3,0,3}, // 25
        };
        for (Integer[] input : inputs) {
            System.out.println("Input = " + KpLearnUtils.printArray(input));
            System.out.println("Water = " + findWater(input));
        }
    }

    private int findWater(Integer arr[])
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = arr.length-1;

        while(lo <= hi)
        {
            if(arr[lo] < arr[hi])
            {
                if(arr[lo] > left_max)
                    // update max in left
                    left_max = arr[lo];
                else
                    // water on curr element = max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else
            {
                if(arr[hi] > right_max)
                    // update right maximum
                    right_max = arr[hi];
                else
                    // water on curr element = max - curr
                    result += right_max - arr[hi];
                hi--;
            }
        }
        return result;
    }

}