package kp.onefilers.geeksforgeeks.ds.array;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

/**
 * Search an element in a sorted and rotated array.
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 */
public class RotatedSortedArrayBinarySearch implements ProgramRunnerApp.ProgramRunner {

    private static final Integer[] rot = new Integer[]{8,11,13,16,22,27,1,5,6};

    public static void main(String[] args) {
        new RotatedSortedArrayBinarySearch().runProgram();
    }

    @Override
    public void runProgram() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("==============================================");
            System.out.println("Array: " + Arrays.asList(rot));
            int input = Integer.parseInt(KpLearnUtils.readInput("Search value: "));
            int index = (binRotSearch(rot, input) + 1);
            if (index == 0) {
                System.out.println("Not found " + input);
            } else {
                System.out.println("Found " + input + " at index: " + (binRotSearch(rot, input) + 1));
            }
        }
    }

    private static int binRotSearch(Integer[] rot, int search) {
        int beg = 0, end = rot.length-1, pos = -1;
        Split split = null;

        while (beg < end) {
            pos = beg + Double.valueOf(Math.ceil((end-beg) / 2)).intValue();
            if (rot[pos] == search) {
                return pos;
            }

            split = (rot[beg] < rot[end])
                    ? splitNormal(rot,pos,beg,end,search)
                    : splitAbnormal(rot,pos,beg,end,search);

            if (Split.RIGHT.equals(split)) {
                beg = pos + 1;
            } else if (Split.LEFT.equals(split)) {
                end = pos - 1;
            }
        }

        return (rot[beg] == search) ? beg : -1;
    }

    private enum Split {
        LEFT, RIGHT;
    }

    private static Split splitNormal(Integer[] rot, int pos, int beg, int end, int search) {
        return (search > rot[pos]) ? Split.RIGHT : Split.LEFT;
    }

    private static Split splitAbnormal(Integer[] rot, int pos, int beg, int end, int search) {
        if (rot[pos] > rot[end]) { // if true abnormal right
            if (search > rot[pos]) {
                return Split.RIGHT;
            } else if (search <= rot[end]) {
                return Split.RIGHT;
            } else {
                return Split.LEFT;
            }
        } else { // if true abnormal left
            if (search < rot[pos]) {
                return Split.LEFT;
            } else if (search >= rot[beg]) {
                return Split.LEFT;
            } else {
                return Split.RIGHT;
            }
        }
    }
}
