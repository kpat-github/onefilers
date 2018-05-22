package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestAverageMarks implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
        new BestAverageMarks().runProgram();
    }

    @Override
    public void runProgram() {
        String[][] marks = new String[][]{
                {"Amogh","100"},
                {"Drushil","62"},
                {"Dhruvi","98"},
                {"Amogh","99"},
                {"Dhruvi","100"},
                {"Dolly","78"},
                {"Drushil","38"},
                {"Dolly","55"},
        };

        maxAverage(marks);
    }

    private void maxAverage(String[][] marks) {
        Integer maxAverage = Integer.MIN_VALUE;
        Map<String,List<Integer>> marksMap = new HashMap<>();
        for (String[] mark : marks) {
            String p = mark[0];
            int m = Integer.parseInt(mark[1]);
            if (!marksMap.containsKey(p)) {
                marksMap.put(p, new LinkedList<>());
            }
            marksMap.get(p).add(m);
        }
        for (String key : marksMap.keySet()) {
            int tm = 0, avg;
            for (int m : marksMap.get(key)) {
                tm += m;
            }
            avg = Double.valueOf(tm/marksMap.get(key).size()).intValue();
            maxAverage = (avg > maxAverage) ? avg : maxAverage;
        }

        System.out.println(String.format("The max-average is: %d",maxAverage));
    }
}
