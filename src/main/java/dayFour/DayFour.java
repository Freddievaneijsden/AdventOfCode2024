package dayFour;

import dayThree.DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) {
        final String textFile = "test.txt";
        final List<String> board = new ArrayList<>();

        File myObj = new File(textFile);
        try {
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                board.add(reader.nextLine());
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        board.forEach(System.out::println);

    }
}
