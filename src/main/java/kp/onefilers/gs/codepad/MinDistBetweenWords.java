package kp.onefilers.gs.codepad;

import kp.onefilers.commons.KpLearnUtils;
import kp.onefilers.commons.ProgramRunnerApp;

public class MinDistBetweenWords implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new MinDistBetweenWords().runProgram();
    }

    @Override
    public void runProgram() {
        String sentence = KpLearnUtils.readInput("Enter the sentence: ");
        String w1 = KpLearnUtils.readInput("Enter first word: ");
        String w2 = KpLearnUtils.readInput("Enter second word: ");
        double l1 = 0, l2 = 0, len = 0, dist = Integer.MAX_VALUE;
        String[] words = sentence.split("\\s+");
        String w = "";
        for (String word : words) {
            if (word.equalsIgnoreCase(w1)) {
                l1 = len + w1.length()/2.0;
                if (w.equalsIgnoreCase(w2)) {
                    dist = (l1-l2 < dist) ? l1-l2 : dist;
                }
                w = w1;
            }
            if (word.equalsIgnoreCase(w2)) {
                l2 = len + w2.length()/2.0;
                if (w.equalsIgnoreCase(w1)) {
                    dist = (l2-l1 < dist) ? l2-l1 : dist;
                }
                w = w2;
            }
            len += word.length()+1;
        }

        System.out.println("Dist: "+dist);

    }
}
