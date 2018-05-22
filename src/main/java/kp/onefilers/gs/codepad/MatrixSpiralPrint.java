package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class MatrixSpiralPrint implements ProgramRunnerApp.ProgramRunner{

    public static void main(String[] args) {
        new MatrixSpiralPrint().runProgram();
    }

    @Override
    public void runProgram() {
        String strIn = KpLearnUtils.readInput("Enter the matrix in the form a,b;c,d : ");
        String [][] mat = parseInputMatrix(strIn);

        int i;
        int re = mat.length-1, ce = mat[0].length-1, rs=0, cs=0;

        while( rs <= re && cs <= ce ) {
            for (int j = cs; j <= ce; j++) {
                System.out.print(mat[rs][j] + " ");
            }
            rs++;
            for (int j = rs; j <= re; j++) {
                System.out.print(mat[j][ce] + " ");
            }
            ce--;
            if (rs <= re) {
                for (int j = ce; j >= cs; j--) {
                    System.out.print(mat[re][j] + " ");
                }
                re--;
            }
            if (cs <= ce) {
                for (int j = re; j >= rs; j--) {
                    System.out.print(mat[j][cs] + " ");
                }
                cs++;
            }
        }
    }

    private String[][] parseInputMatrix(String str) {
        String[] rows = str.split(";");
        String[][] mat = new String[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            mat[i] = rows[i].split(",");
        }

        return mat;
    }
}
