import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algo {
    public static ArrayList<String> output(int space, String lettersStr) throws IOException {
        char[] letters = lettersStr.toCharArray();

        return foundWords(space, letters);
    }


    public static ArrayList<String> foundWords(int space, char[] letters) throws IOException {
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
        ArrayList<String> words = new ArrayList<>();
//        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
        ArrayList<Scanner> scanners = scannersToBeSearched(space, letters);

        for (Scanner scanner : scanners) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (canWordBeUsed(word, letters)){
                    words.add(word);

                }
            }
        }
        return words;
    }


    public static boolean canWordBeUsed(String word, char[] letters){
        String pattern = "^[" + Arrays.toString(letters) +"]{2" +letters.length + "}$";
        return word.matches(pattern);
    }

    public static ArrayList<Scanner> scannersToBeSearched(int space, char[] letters) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters);

        for (int i = constraints; i > 1; i--) {
            String pathname = "src\\words" + i + ".txt";
            scannersToBeSearched.add(new Scanner(new FileReader(pathname)));
        }

        return scannersToBeSearched;
    }

    public static ArrayList<BufferedReader> readersToBeSearched(int space, char[] letters) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<BufferedReader> readersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters);

        for (int i = constraints; i > 1; i--) {
            String pathname = "src\\words" + i + ".txt";
            readersToBeSearched.add(new BufferedReader(new FileReader(pathname)));
        }

        return readersToBeSearched;
    }


    public static int constraints(int space, char[] letters) {
        int constrains = letters.length;
        if (space < letters.length) {
            constrains = space;
        }

        return constrains;
    }
}
