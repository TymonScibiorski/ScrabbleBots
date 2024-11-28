import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Algo {
    public static ArrayList<String> output(String lettersStr, String mustContain, String beginsWith, String endsIn, int space, Integer amountOfBlankTiles) throws IOException {
        return foundWords(space, lettersStr, beginsWith, endsIn, mustContain, amountOfBlankTiles);
    }


    public static ArrayList<String> foundWords(int space, String letters, String beginsWith, String endsWith, String mustContain, Integer amountOfBlankTiles) throws IOException {
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
        ArrayList<String> words = new ArrayList<>();
//        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
        ArrayList<Scanner> scanners = scannersToBeSearched(space, letters, amountOfBlankTiles);

        for (Scanner scanner : scanners) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                if (canWordBeUsed(word, letters, beginsWith, endsWith, mustContain, amountOfBlankTiles)) {
                    words.add(word);
                }
            }
        }
        return words;
    }


    public static boolean canWordBeUsed(String word, String playaLettersStr, String beginsWith, String endsWith, String mustContain, Integer amountOfBlankTiles) {
        //This method checks if a given word can be constructed with the Player's letters and if it starts and ends with optionally specified strings
        HashMap<Character, Integer> checkedWord = stringToHashMap(word);
        HashMap<Character, Integer> playaLetters = stringToHashMap(playaLettersStr);

            if (!doLettersMatch(playaLetters, checkedWord, amountOfBlankTiles)) {
            return false;
        }

        if (!doesBeginningAndEndMatch(word, beginsWith, endsWith)) {
            return false;
        }

        if (!containsMustContain(word, mustContain)) {
            return false;
        }

        return true;

    }

    public static boolean doesStringMatchGivenLetterPattern2(String word, String usersPattern){
        if (usersPattern.length() < word.length()){
            return false;
        }

        if (usersPattern.length() == word.length()){
            HashMap<Character, Character> wordAndPatternMap = twoStringsOfEqualLengthToHashMap(word, usersPattern);

            for (Map.Entry<Character, Character> entry : wordAndPatternMap.entrySet()) {
                if (!(entry.getValue().equals(entry.getKey())  || entry.getValue().equals('_'))) {
                    return false;
                }
            }

            return true;
        }

        return true;
    }



    public static boolean doesStringMatchGivenLetterPattern(String word, String usersPattern) {
        char[] checkedWord = word.toCharArray();
        char[] pattern = usersPattern.toCharArray();

        for (int i = 0; i < checkedWord.length; i++) {
            char checkedWordChar = checkedWord[i];
            int amountOfLettersCheckedFromWord = i;

            if (checkedWordChar != pattern[i]) {
                continue;
            }

            int numberBeforePatternLetter = checkedWord[i-1] - '0';

            if (checkedWordChar == pattern[1]) {// If the code encounters the first letter from the pattern in the word
                if(numberBeforePatternLetter < amountOfLettersCheckedFromWord) { // and there have been more letters than the number before the letter, than the word's beginning is too long.
                    return false;
                }
                continue;
            }

            if (numberBeforePatternLetter == 0){ // If [the number] before [found pattern letter] is zero than some other letter from the pattern should've already been found, and since this is NOT [the first letter form the pattern] then the word doesn't contain a crucial letter
                return false;
            }

            if (numberBeforePatternLetter < amountOfLettersCheckedFromWord){ // If
                return false;
            }

            int numberAfterPatternLetter = checkedWord[i+1] - '0';
            if (numberAfterPatternLetter > checkedWord.length-i){ // If there's fewer letters left in the word than the amount of letters permitted after X, then it doesn't "touch" the next letter, so it should be permitted
                return true;
            }


        }
        return true;
    }

    public static boolean containsMustContain(String word, String mustContain) {
        if (mustContain == null) {
            return true;
        }
        if (word.contains(mustContain)) {
            return true;
        }
        return false;
    }


    public static boolean doesBeginningAndEndMatch(String word, String beginsWith, String endsWith) {
        if (!beginsWith.isBlank() && !word.startsWith(beginsWith)) {
            return false;
        }
        if (!endsWith.isBlank() && !word.endsWith(endsWith)) {
            return false;
        }

        return true;
    }

    public static boolean doLettersMatch(HashMap<Character, Integer> playaLetters, HashMap<Character, Integer> checkedWord, Integer amountOfBlankTiles) {
        // Foring through letters in the checked word
        for (Map.Entry<Character, Integer> entry : checkedWord.entrySet()) {
            int amountOfTheCheckedLetterInPlayaLetters = playaLetters.getOrDefault(entry.getKey(), 0);

            if ((amountOfTheCheckedLetterInPlayaLetters < checkedWord.get(entry.getKey()))) {
                if (amountOfTheCheckedLetterInPlayaLetters == 0 && checkedWord.get(entry.getKey()) <= amountOfBlankTiles) {
                    amountOfBlankTiles -= checkedWord.get(entry.getKey()) - amountOfTheCheckedLetterInPlayaLetters;
                    continue;
                }
                return false;
            }
        }

        return true;
    }


    public static ArrayList<Scanner> scannersToBeSearched(int space, String letters, Integer amountOfBlankTiles) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();
        int constraints = constraints(space, letters.length());

        for (int i = 2; i <= constraints+amountOfBlankTiles; i++) {
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

    private static HashMap<Character, Character> twoStringsOfEqualLengthToHashMap(String word1, String word2) {
        HashMap<Character, Character> map = new HashMap<>();

        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        for (int i = 0; i < word1Array.length; i++) {
            map.put(word1Array[i], word2Array[i]);
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
