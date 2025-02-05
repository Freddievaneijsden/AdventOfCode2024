package dayThree;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {

    public static void main(String[] args) {
        final String textFile = "dayThreeInput.txt";
        String dayThreeInput = "";
        List<String> uncorruptedMul = new ArrayList<>();


        dayThreeInput = fileToString(textFile);
//        System.out.println(dayThreeInput);

        Pattern pattern = Pattern.compile("mul\\([0-9]*,[0-9]*\\)");
        Matcher matcher = pattern.matcher(dayThreeInput);

        while (matcher.find()) {
            uncorruptedMul.add(matcher.group());
        }

        uncorruptedMul.forEach(System.out::println);
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
