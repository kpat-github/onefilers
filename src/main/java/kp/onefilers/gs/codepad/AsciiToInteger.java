package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

public class AsciiToInteger implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new AsciiToInteger().runProgram();
    }

    @Override
    public void runProgram() {
        int asciiValue = '9';
        if ('0' <= asciiValue && asciiValue <= '9') {
            System.out.println(String.format("Integer value for ASCII %d is: %d",asciiValue,asciiValue-'0'));
        } else {
            System.out.println(String.format("Not an integer ASCII: %d",asciiValue));
        }
    }
}
