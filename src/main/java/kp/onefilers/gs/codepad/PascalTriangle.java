package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;

public class PascalTriangle implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new PascalTriangle().runProgram();
    }

    @Override
    public void runProgram() {
        int row = 23, col = row/2; // simulated input from user.
        if (row < col) {
            System.out.println("Invalid Pascal-Triangle index (" + row + "," + col + "); row can not be less than column");
            return;
        }
        Map<Integer,List<Integer>> pascalMap = new HashMap<>();
        pascalMap.put(0, new ArrayList(Arrays.asList(1)));
        for (int i = 1; i < row; i++) {
            List<Integer> preList = pascalMap.get(i-1);
            List<Integer> list = new ArrayList<>(Arrays.asList(1));
            for (int j = 0; j < preList.size() -1; j++) {
                int sum = preList.get(j) + preList.get(j+1);
                list.add(sum);
            }
            list.add(1);
            pascalMap.put(i,list);
        }
        System.out.println("Element at (" + row + "," + col + ") : " + pascalMap.get(row - 1).get(col - 1));
    }
}
