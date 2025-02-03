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

        scanEachLineToList(textFile, dayTwoInput);
        splitStringBySpaceAndSaveInListOfLists(dayTwoInput, reportListString);

        List<List<Integer>> reportList = convertListOfListsWithStringToInteger(reportListString);

        System.out.println(isLevelsIncreasing(reportList.get(1)));
        reportList.forEach(System.out::println);
    }

    private static void splitStringBySpaceAndSaveInListOfLists(List<String> dayTwoInput, List<List<String>> reportListString) {
        for (String s : dayTwoInput) {
            List<String> singleReportListString;
            List<String> singleReportList = new ArrayList<>();
            singleReportListString = List.of(s.split("\\s+"));
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
            if (report.get(i+1) > report.get(i) && (report.get(i+1) - report.get(i) >= 4) ) {
                return false;
            }
            System.out.println("Number: " + report.get(i) + " = valid increase");
        }
        return true;
    }
}
