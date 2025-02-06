package dayThree;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class DayThreePartTwo {

        public static void main(String[] args) {
            final String textFile = "dayThreeInput.txt";
            String dayThreeInput = fileToString(textFile);
            String corruptedSection = "don't\\(\\).*?do\\(\\)";
            String lastDontSection = "don't\\(\\).*";

            dayThreeInput = dayThreeInput.replace("\n", "");

            Pattern pattern = Pattern.compile(corruptedSection);
            Matcher matcher = pattern.matcher(dayThreeInput);
            while (matcher.find()) {
                String subString = matcher.group();
                dayThreeInput = dayThreeInput.replace(subString,"");
            }


            Pattern pattern2 = Pattern.compile(lastDontSection);
            Matcher matcher2 = pattern2.matcher(dayThreeInput);
            while (matcher2.find()) {
                String subString = matcher2.group();
                dayThreeInput = dayThreeInput.replace(subString,"");
            }


            List<String> uncorruptedMul = new ArrayList<>(addMatchToList(dayThreeInput));
            List<int[]> mappedNumbers = new ArrayList<>(separatePairs(uncorruptedMul));

            int total = 0;
            for (int i = 0; i < mappedNumbers.size(); i++) {
                int[] pair = mappedNumbers.get(i);
                int firstNumber = pair[0];
                int secondNumber = pair[1];
                total += firstNumber * secondNumber;
            }

            System.out.println(total);
        }

        public static List<int[]> separatePairs(List<String> listString){
            List<int[]> mappedNumbers = new ArrayList<>();
            for (String pair : listString) {
                String[] parts = pair.split(",");
                int firstNumber = Integer.parseInt(parts[0].trim());
                int secondNumber = Integer.parseInt(parts[1].trim());
                mappedNumbers.add(new int[]{firstNumber, secondNumber});
            }
            return mappedNumbers;
        }

        public static List<String> addMatchToList (String input) {
            List<String> uncorruptedMul = new ArrayList<>();
            Pattern pattern = Pattern.compile("mul\\(([0-9]*,[0-9]*)\\)");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                uncorruptedMul.add(matcher.group(1));
            }
            return uncorruptedMul;
        }

        public static String fileToString(String p) {
            Path path = Paths.get(p);
            String content = "";
            try {
                content = Files.readString(path);
            } catch (IOException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
            return content;
        }
    }
