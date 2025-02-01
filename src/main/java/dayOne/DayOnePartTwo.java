package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;

public class DayOnePartTwo {

    public static void main(String[] args) {
        final String myTextFile = "dayOneInput.txt";
        List<String> leftAndRightNumber = new ArrayList<>();
        List<String> separatedNumbers;
        List<Integer> leftNumber = new ArrayList<>();
        List<Integer> rightNumber = new ArrayList<>();

        try {
            File myObj = new File(myTextFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                leftAndRightNumber.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        separatedNumbers = leftAndRightNumber.stream()
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .toList();

        for (int i = 0; i < separatedNumbers.size(); i++) {
            if (i % 2 == 0) {
                leftNumber.add(Integer.parseInt(separatedNumbers.get(i)));
            } else {
                rightNumber.add(Integer.parseInt(separatedNumbers.get(i)));
            }
        }

        countFrequenciesEachLeftNumberOccurInRightList(leftNumber, rightNumber);
    }

    private static void countFrequenciesEachLeftNumberOccurInRightList (List<Integer> Leftlist, List<Integer> rightList) {
        Map<Integer, Integer> leftOccurrences = new HashMap<Integer, Integer>();
        int totalSimilarityScore = 0;
        for (Integer i : Leftlist) {
            int count = 0;
            for (Integer integer : rightList) {
                if (Objects.equals(i, integer)) {
                    count += 1;
                }
//                leftOccurrences.compute(i, (k, j) -> (j == null) ? 1 : j + 1);
//                for (Map.Entry<Integer, Integer> val : leftOccurrences.entrySet()) {
//                    System.out.println("Number " + val.getKey() + " "
//                            + "occurs"
//                            + ": " + val.getValue() + " times");
            }
            totalSimilarityScore += similarityScore(i, count);
            System.out.println(i + ": " + count);

        }
        System.out.println(totalSimilarityScore);
    }

    public static int similarityScore(int currentInt, int count) {
        return currentInt * count;
    }
}
