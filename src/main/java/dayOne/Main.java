package dayOne;

import javax.lang.model.type.IntersectionType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
//        String content = URLConnectionReader.getText("https://adventofcode.com/2024/day/1/input");
//        System.out.println(content);

        final String myTextFile = "dayOneInput.txt";
        List<String> leftAndRightNumber = new ArrayList<>();
        List<String> separatedNumbers;
        List<Integer> leftNumber = new ArrayList<>();
        List<Integer> rightNumber = new ArrayList<>();
        List<Integer> smallestLeft = new ArrayList<>();
        List<Integer> smallestRight = new ArrayList<>();
        List<Integer> distanceBetweenNumbers = new ArrayList<>();
        int sumDistance = 0;

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

//        for (int i = 0; i < leftNumber.size(); i++) {
//            char[] splitNumbers = leftNumber.get(i).toCharArray();
//
//            int smallest = splitNumbers[0] - '0'; // Convert the first character to int
//
//            // Loop through the array starting from the second element
//            for (int j = 1; j < splitNumbers.length; j++) {
//                int currentNumber = splitNumbers[j] - '0'; // Convert the char to int
//
//                // Compare with the current smallest value
//                if (currentNumber < smallest) {
//                    smallest = currentNumber; // Update smallest if a smaller number is found
//                }
//            }
//
//            smallestLeft.add(smallest);
//        }

//        for (int i = 0; i < rightNumber.size(); i++) {
//            char[] splitNumbers = rightNumber.get(i).toCharArray();
//
//            int smallest = splitNumbers[0] - '0'; // Convert the first character to int
//
//            // Loop through the array starting from the second element
//            for (int j = 1; j < splitNumbers.length; j++) {
//                int currentNumber = splitNumbers[j] - '0'; // Convert the char to int
//
//                // Compare with the current smallest value
//                if (currentNumber < smallest) {
//                    smallest = currentNumber; // Update smallest if a smaller number is found
//                }
//            }
//
//            smallestRight.add(smallest);
//        }

//        for (int i = 0; i < smallestLeft.size(); i++) {
//            int diff = Math.abs(smallestLeft.get(i) - smallestRight.get(i));
//            distanceBetweenNumbers.add(diff);
//        }
//
//        for (int i = 0; i < distanceBetweenNumbers.size(); i++) {
//            sumDistance += distanceBetweenNumbers.get(i);
//        }

        Collections.sort(leftNumber);
        Collections.sort(rightNumber);

        for (int i = 0; i < leftNumber.size(); i++) {
            int diff = Math.abs(leftNumber.get(i) - rightNumber.get(i));
            distanceBetweenNumbers.add(diff);
        }

        for (int i = 0; i < distanceBetweenNumbers.size(); i++) {
            sumDistance += distanceBetweenNumbers.get(i);
        }

        distanceBetweenNumbers.forEach(System.out::println);
        System.out.println(sumDistance);
//        smallestLeft.forEach(System.out::println);
//        smallestRight.forEach(System.out::println);
//        leftNumber.forEach(System.out::println);
//        rightNumber.forEach(System.out::println);

    }
}

