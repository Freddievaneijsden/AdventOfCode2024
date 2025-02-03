package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DayTwo {

    public static void main(String[] args) {
        final String textFile = "test.txt";
        List<String> dayTwoInput = new ArrayList<>();
        List<List<String>> reportListString = new ArrayList<>();
        List<List<Integer>> safeReports = new ArrayList<>();

        scanEachLineToList(textFile, dayTwoInput);
        splitStringBySpaceAndSaveInListOfLists(dayTwoInput, reportListString);

        List<List<Integer>> reportList = convertListOfListsWithStringToInteger(reportListString);

//        System.out.println(checkIfReportIsSafe(reportList.get(5)));
        System.out.println(isLevelsIncreasing(reportList.get(5)));

        reportList.forEach(System.out::println);
    }

    private static void splitStringBySpaceAndSaveInListOfLists(List<String> dayTwoInput, List<List<String>> reportListString) {
        for (String s : dayTwoInput) {
            List<String> singleReportListString;
            List<String> singleReportList = new ArrayList<>();
            singleReportListString = java.util.List.of(s.split("\\s+"));
            for (int i = 0; i < singleReportListString.size(); i++) {
//                singleReportList.add(Integer.parseInt(singleReportListString.get(i)));
                  singleReportList.add(singleReportListString.get(i));
            }
            reportListString.add(singleReportList);
        }
    }

    private static void scanEachLineToList(String textFile, List<String> dayTwoInput) {
        try {
            File myObj = new File(textFile);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                dayTwoInput.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }
    }

    private static List<List<Integer>> convertListOfListsWithStringToInteger(List<List<String>> reportListString) {
        List<List<Integer>> reportList = new ArrayList<>();
        List<Integer> singleReportList;
        for (int i = 0; i < reportListString.size(); i++) {
            singleReportList = reportListString.get(i).stream()
                    .map(Integer::parseInt)
                    .toList();
            reportList.add(singleReportList);
        }
        return reportList;
    }

    private static boolean isLevelsIncreasing(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) < report.get(i+1)) {
                int diff = Math.abs(report.get(i) - report.get(i + 1));

                if (diff > 3 || diff == 0) {
                    System.out.println("Number: " + report.get(i) + " = invalid increase (by " + diff + ")");
                    return false;
                }
                System.out.println("Number: " + report.get(i) + " = valid increase (by " + diff + ")");
            }
        }
        return true;
    }

    private static boolean isLevelsDecreasing(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) > report.get(i+1)) {
                int diff = report.get(i) - report.get(i + 1);

                if (diff > 3 || diff == 0) {
                    System.out.println("Number: " + report.get(i) + " = invalid decrease (by " + diff + ")");
                    return false;
                }
                System.out.println("Number: " + report.get(i) + " = valid decrease (by " + diff + ")");
            }
        }
        return true;
    }

    private static boolean checkIfReportIsSafe(List<Integer> report) {
        if (isLevelsIncreasing(report)) {
            return true;
        }
        return false;
    }

    private static void saveSafeReport (List<Integer> report, List<List<Integer>> safeReports) {
        if (checkIfReportIsSafe(report)) {
            safeReports.add(report);
        }
    }
}
