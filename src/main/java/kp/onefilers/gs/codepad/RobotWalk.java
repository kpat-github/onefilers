package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class RobotWalk implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new RobotWalk().runProgram();
    }

    @Override
    public void runProgram() {
        int[] initPos = new int[]{0,0};
        String[] movesSet = new String[]{
                "UDDLRL",
                "UDDLLRUUUDUURUDDUULLDRRRR",
                "ZZzzz",
        };
        for (String moves : movesSet) {
            System.out.println(String.format("Input: pos=(%d, %d) | moves=%s",initPos[0],initPos[1],moves));
            int[] finalPos = walkTheRobot(initPos, moves);
            System.out.println(String.format("Final position: (%d, %d)", finalPos[0], finalPos[1]));
        }
    }

    private int[] walkTheRobot(int[] initPos, String moves) {
        int[] finalPos = new int[]{initPos[0],initPos[1]};

        for (char c : moves.toUpperCase().toCharArray()) {
            switch(c) {
                case 'U':
                    finalPos[1]++;
                    break;
                case 'D':
                    finalPos[1]--;
                    break;
                case 'R':
                    finalPos[0]++;
                    break;
                case 'L':
                    finalPos[0]--;
                    break;
                default:
                    System.err.println(">>> Skipping unknown move: "+c);
            }
        }

        return finalPos;
    }
}
