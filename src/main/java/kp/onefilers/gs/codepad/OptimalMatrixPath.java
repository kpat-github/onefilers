package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class OptimalMatrixPath implements ProgramRunnerApp.ProgramRunner{

    public static void main(String[] args) {
        new OptimalMatrixPath().runProgram();
    }

    @Override
    public void runProgram() {
        Integer[][] grid = new Integer[][] {{0, 100, 0, 0, 5},{0, 1, 1, 1, 0},{10, 0, 5, 0, 0},{2, 0, 5, 0, 0},{2, 0, 5, 0, 0},};
        int rows = grid.length, cols = grid[0].length;
        Integer[][] path = new Integer[rows][cols];
        path[rows-1][0] = grid[rows-1][0];

        for (int i = rows-1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                Integer left = (j == 0)?0:path[i][j-1];
                Integer down = (i == rows-1)?0:path[i+1][j];
                path[i][j] = grid[i][j] + (left>down?left:down);
            }
        }
        System.out.println("Maximum weight from bottom-left to top-right is: "+path[0][cols-1]);
    }
}
