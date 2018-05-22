package kp.onefilers.geeksforgeeks.ds.array;

public class MaxValuePositionProductWithRotation {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println("Max sum is " + maxSum(arr));
    }

    static int maxSum(int arr[])
    {
        // Find array sum and i*arr[i] with no rotation
        int arrSum = 0;  // Stores sum of arr[i]
        int currVal = 0;  // Stores sum of i*arr[i]
        for (int i=0; i<arr.length; i++)
        {
            arrSum = arrSum + arr[i];
            currVal = currVal+(i*arr[i]);
        }
        // Initialize result as 0 rotation sum
        int maxVal = currVal;
        // Try all rotations one by one and find
        // the maximum rotation sum.
        for (int j=1; j<arr.length; j++)
        {
            /**
             * as with each clock-wise rotation each element's contribution increases by 1 fold
             * (as the one multiplied earlier by 2 is now multiplied by 3 etc.)
             * thus the complete sum increases by
             */
            currVal = currVal + arrSum-arr.length*arr[arr.length-j];
            if (currVal > maxVal)
                maxVal = currVal;
        }
        // Return result
        return maxVal;
    }
}
