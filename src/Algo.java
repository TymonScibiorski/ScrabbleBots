import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Algo {
    public static ArrayList<String> output(int space, String lettersStr) throws IOException {

        return foundWords(space, lettersStr);
    }


    public static ArrayList<String> foundWords(int space, String letters) throws IOException {
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


    public static boolean canWordBeUsed(String word, String playaLettersStr){
        HashMap<Character, Integer> checkedWord = stringToHashMap(word);
        HashMap<Character, Integer> playaLetters = stringToHashMap(playaLettersStr);

        for (Map.Entry<Character, Integer> entry : checkedWord.entrySet()) {
            int amountOfLetterInPlayaLetters = playaLetters.getOrDefault(entry.getKey(), 0);

            if (amountOfLetterInPlayaLetters == 0 || amountOfLetterInPlayaLetters < checkedWord.get(entry.getKey())) {
                return false;
            }

        }

        return true;
    }


    public static ArrayList<Scanner> scannersToBeSearched(int space, String letters) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters.length());

        for (int i = constraints; i > 1; i--) {
            String pathname = "src\\words" + i + ".txt";
            scannersToBeSearched.add(new Scanner(new FileReader(pathname)));
        }

        return scannersToBeSearched;
    }


    public static int constraints(int space, int amountOfLetters) {
        int constrains = amountOfLetters;
        if (space < amountOfLetters) {
            constrains = space;
        }

        return constrains;
    }

    private static HashMap<Character, Integer> stringToHashMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : word.toCharArray()){
            int occurences = map.getOrDefault(c, 0) + 1;
            map.put(c, occurences);
        }

        return map;
    }

//    public static ArrayList<BufferedReader> readersToBeSearched(int space, HashMap<Character, Integer> letters) throws FileNotFoundException {
//        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
//        ArrayList<BufferedReader> readersToBeSearched = new ArrayList<>();
//        int constraints = constraints(space, letters);
//
//        for (int i = constraints; i > 1; i--) {
//            String pathname = "src\\words" + i + ".txt";
//            readersToBeSearched.add(new BufferedReader(new FileReader(pathname)));
//        }
//
//        return readersToBeSearched;
//    }
}
