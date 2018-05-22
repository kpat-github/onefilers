package kp.onefilers.geeksforgeeks.ds.array;

public class RotateArray {
    public static void main(String[] args) {
        int rot = 3;
        rotateLeft(new int[]{1,2,3,4,5,6,7}, rot);
        rotateRight(new int[]{1,2,3,4,5,6,7}, rot);
    }

    private static void rotateLeft(int[] arr, int rot) {
        int len = arr.length;
        int eff_rot = (rot % len);
        int[] temp = new int[eff_rot];
        System.out.println("Input:");
        for (int i = 0; i < len; i++) {
            System.out.print(""+arr[i]+" ");
        }
        System.out.println("");
        for (int i = 0; i < len+eff_rot; i++) {
            if (i < eff_rot) {
                temp[i] = arr[i];
            } else if (i < len) {
                arr[i-eff_rot] = arr[i];
            } else {
                int ri = i - len;
                arr[len-eff_rot+ri] = temp[ri];
            }
        }
        System.out.println("Output: ");
        for (int i = 0; i < len; i++) {
            System.out.print(""+arr[i]+" ");
        }
    }

    private static void rotateRight(int[] arr, int rot) {
        int len = arr.length;
        int eff_rot = (rot % len);
        int[] temp = new int[eff_rot];
        System.out.println("Input:");
        for (int i = 0; i < len; i++) {
            System.out.print(""+arr[i]+" ");
        }
        System.out.println("");
        for (int i = len-1; i > -eff_rot; i--) {
            if (i > len-eff_rot) {
                temp[len-i] = arr[i-eff_rot];
            } else if (i > -1) {
                arr[i+eff_rot] = arr[i];
            } else {
                arr[eff_rot+i] = temp[eff_rot+i];
            }
        }
        System.out.println("Output: ");
        for (int i = 0; i < len; i++) {
            System.out.print(""+arr[i]+" ");
        }
    }
}
