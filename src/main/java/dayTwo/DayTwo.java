package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) {
        final String dayTwoInput = "test.txt";
        List<String> input = new ArrayList<>();

        try {
            File myObj = new File(dayTwoInput);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                input.add(data);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }



        input.forEach(System.out::println);
    }
}
