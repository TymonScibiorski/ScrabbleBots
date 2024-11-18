import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Algo {
    public static ArrayList<String> output(){
        int space = 7;
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'h', 'i', 'j',};

        return foundWords(space, letters);
    }

    public static ArrayList<String> foundWords(int space, char[] letters){
        ArrayList<String> foundWords = new ArrayList<>();



        return foundWords;
    }

    public static ArrayList<Scanner> scannersToBeSearched(int space, char[] letters) throws FileNotFoundException {
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters);


        if (constraints == 3){
            scannersToBeSearched.add(new Scanner(new File("src\\testWords3")));
            scannersToBeSearched.add(new Scanner(new File("src\\testWords2")));
        }

        return scannersToBeSearched;
    }

    private static int constraints(int space, char[] letters) {
        int constrains = space;
        if (space < letters.length) {
            constrains = space;
        }
        else {
            constrains = letters.length;
        }
        return constrains;
    }
}
