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
        final List<String> stringArray = new ArrayList<>();
        List<char[]> board = new ArrayList<>();
        
        File myObj = new File(textFile);
        try {
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                stringArray.add(reader.nextLine());
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        createMultidimensionalArray(stringArray, board);

        System.out.println(board.get(0)[4]);
    }

    private static void createMultidimensionalArray(List<String> stringArray, List<char[]> board) {
        for (int i = 0; i < stringArray.size(); i++) {
                board.add(stringArray.get(i).toCharArray());
        }
    }

    public static boolean findWord (List<String> board, String word) {
        int rows = board.size();
        int columns;
        for (int i = 0; i < rows; i++) {
        }

        return false;
    }
}
