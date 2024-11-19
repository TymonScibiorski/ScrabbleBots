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
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
        ArrayList<String> foundWords = new ArrayList<>();



        return foundWords;
    }

    public static ArrayList<Scanner> scannersToBeSearched(int space, char[] letters) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters);

        for (int i = 1; i <= constraints; i++) {
            String pathname = "src\\words" + i + ".txt";
            scannersToBeSearched.add(new Scanner(new File(pathname)));
        }

        return scannersToBeSearched;
    }

    public static int constraints(int space, char[] letters) {
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
