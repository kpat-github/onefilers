package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class MatrixDotAndCrossProduct implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new MatrixDotAndCrossProduct().runProgram();
    }

    @Override
    public void runProgram() {
        int[][] matrix1 = {
                {1,2},
                {3,4},
                {5,6},
        };
        int[][] matrix2 = {
                {1,2,3,4,5,6},
                {4,5,6,1,2,3},
        };

        Integer[][] cp = crossProduct(matrix1,matrix2);
        if (cp != null) {
            System.out.println("Cross product is:");
            for (Integer[] arr : cp) {
                System.out.println(KpLearnUtils.printArray(arr));
            }
        }
    }

    private Integer[][] crossProduct(int[][] m1, int[][] m2) {
        Integer[][] cp = new Integer[m1.length][m2[0].length];

        if (m1[0].length != m2.length) {
            System.out.println("Input matrices not compatible for cross-product");
            return null;
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                cp[i][j] = 0;
                for (int k = 0; k < m2.length; k++) {
                    cp[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }

        return cp;
    }
}
