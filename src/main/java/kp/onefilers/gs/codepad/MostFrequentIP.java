package kp.onefilers.gs.codepad;

import kp.onefilers.commons.ProgramRunnerApp;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostFrequentIP implements ProgramRunnerApp.ProgramRunner {

    public static void main(String[] args) {
//        System.out.println(Pattern.matches(, "11"));
        new MostFrequentIP().runProgram();
    }

    @Override
    public void runProgram() {
        String[] input = new String[] {
                "127.0.0.1 127.0.0.1 127.0.0.1 127.0.0.1 127.0.0.1 ",
                "100.0.0.2- frank [10/Oct/2000:13:55:36" + " -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.0.2- frank [10/Oct/2000:13:55:36" + " -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.0.2- frank [10/Oct/2000:13:55:36" + " -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.0.1- frank [10/Oct/2000:13:55" + ":36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.2.1- frank [10/Oct/2000:13:55" + ":36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.0.1- frank [10/Oct/2000:13:55" + ":36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
                "100.0.2.1- frank [10/Oct/2000:13:55" + ":36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                        + "\"http://www.example.com/start.html\" \"Mozilla/4.08 " + "[en] (Win98; I ;Nav)\"",
        };
        System.out.println("The most frequent IP(s): "+countIPs(input));
    }

    private List<String> countIPs(String[] logLines) {
        Map<String,Integer> ipMap = new HashMap<>();
        int maxCount = 0;
        List<String> mostFreqIP = new LinkedList<>();
        Pattern pattern = Pattern.compile("(?=(\\s\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}))");
        for (String logLine : logLines) {
            Matcher matcher = pattern.matcher(" "+logLine);
            while(matcher.find()) {
                String ip = matcher.group(1);
                if (!ipMap.containsKey(ip)) {
                    ipMap.put(ip,0);
                }
                int count = ipMap.get(ip)+1;
                ipMap.put(ip, count);
                if (count > maxCount) {
                    mostFreqIP.clear();
                    mostFreqIP.add(ip);
                    maxCount = count;
                } else if (count == maxCount) {
                    mostFreqIP.add(ip);
                }
            }
        }
        return mostFreqIP;
    }
}
