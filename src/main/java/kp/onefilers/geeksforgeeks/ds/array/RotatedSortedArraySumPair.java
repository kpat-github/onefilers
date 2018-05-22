package kp.onefilers.geeksforgeeks.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RotatedSortedArraySumPair {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int sum = 11;
        int h = 0, l = 0, len = arr.length;
        for (; h < len -1 && arr[h] < arr[h+1]; h++);
        l = (h+1)%len;
        System.out.println("High = "+h+" Low = "+l);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
        System.out.println("Sum = "+sum);
        boolean flag = true;
        while (l != h) {
            int testSum = arr[l] + arr[h];
            if (testSum == sum) {
                System.out.println("Found "+arr[l]+"("+l+")"+" and "+arr[h]+"("+h+")");
                flag = false;
                h = (len + h - 1) % len;
                l = (l + 1) % len;
            } else if (testSum > sum) {
                h = (len + h - 1) % len;
            } else {
                l = (l + 1) % len;
            }
        }
        if (flag) {
            System.out.println("Not found.");
        }
    }
}
