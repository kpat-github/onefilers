package kp.onefilers.commons;

import kp.learn.gs.codepad.*;
import kp.onefilers.gs.codepad.*;

import java.util.Map;
import java.util.TreeMap;

public class ProgramRunnerApp {
    private static final Map<Integer, ProgramRunner> programs = new TreeMap<>();
    static {
        programs.put(1, new SecondSmallestInUnsortedArray());
        programs.put(2, new SecondSmallestInSortedRotatedArray());
        programs.put(3, new Anagrams());
        programs.put(4, new MinDistBetweenWords());
        programs.put(5, new FirstUniqueCharacterInString());
        programs.put(6, new LongestUniqueCharacterString());
        programs.put(7, new MatrixSpiralPrint());
        programs.put(8, new AddFractions());
        programs.put(9, new LongestPalindrome());
        programs.put(10, new PascalTriangle());
        programs.put(11, new LongestFirstRepeatingCharacters());
        programs.put(12, new BiggestNumberFromListOfNumbers());
        programs.put(13, new SumPairs());
        programs.put(14, new PangramsMissingCharacters());
        programs.put(15, new IsPowerOf());
        programs.put(16, new CountDistinctCharacters());
        programs.put(17, new Fibonacci());
        programs.put(18, new BinarySearchTree<Integer>()); //Do it again
        programs.put(19, new AsciiToInteger());
        programs.put(20, new ArmstrongNumber());
        programs.put(21, new PowerPairs());
        programs.put(23, new MinimumSubArrayExceedingSum());
        programs.put(24, new NewtonRaphsonSqrRoot());
        programs.put(25, new StairCaseProblem());
        programs.put(26, new PrimeFactors());
        programs.put(27, new BestAverageMarks());
        programs.put(28, new MatrixDotAndCrossProduct());
        programs.put(29, new OptimalMatrixPath());
        programs.put(30, new MostFrequentIP());
        programs.put(31, new RobotWalk());
        programs.put(32, new TrappedBetweenWalls());
        programs.put(34, new LongestWordInDictionary());
        programs.put(35, new LinkedListOperations());
    }

    public static void main(String[] args) {
        Integer choice = 0;



        String carryOn = "N";
        do {
            choice = 0;
            System.out.println("==========================================");
            System.out.println("Program list:");

            for (Map.Entry entry : programs.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getClass().getName());
            }
            String strChoice = KpLearnUtils.readInput("Choose program number to run ('0' to exit):");
            try {
                choice = Integer.parseInt(strChoice);
                if (programs.containsKey(choice)) {
                    ProgramRunner pc = programs.get(choice);
                    System.out.println("### START : "+pc.getClass().getName());
                    pc.runProgram();
                    System.out.println("### END : "+pc.getClass().getName());
                } else {
                    System.out.println("Invalid program choice: "+strChoice);
                }
            } catch (Exception e) {
                System.out.println("Invalid program choice: "+strChoice);
            }
            carryOn = KpLearnUtils.readInput("Continue (Y/N) ?");
        } while ("Y".equalsIgnoreCase(carryOn));
    }

    public static interface ProgramRunner {
        void runProgram();
    }
}
