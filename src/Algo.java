import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Algo {
    public static ArrayList<String> output(String lettersStr, String intersectsWord, String pattern, String mustContainPhrase, String beginsWith, String endsIn, String mustContainLetters, int space, Integer amountOfBlankTiles) throws IOException {
        lettersStr += mustContainPhrase + beginsWith + endsIn;

        return foundWords(space, lettersStr, pattern, beginsWith, endsIn, mustContainPhrase, mustContainLetters, amountOfBlankTiles, intersectsWord);
    }


    public static ArrayList<String> foundWords(int space, String letters, String pattern, String beginsWith, String endsWith, String mustContain, String mustContainLetters, Integer amountOfBlankTiles, String intersectsWord) throws IOException {
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
        ArrayList<String> words = new ArrayList<>();
//        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
        ArrayList<Scanner> scanners = scannersToBeSearched(constraints(space, letters.length()+amountOfBlankTiles, pattern.length()));

        for (Scanner scanner : scanners) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                if (canWordBeUsed(word, letters, pattern, beginsWith, endsWith, mustContain, mustContainLetters, amountOfBlankTiles, intersectsWord)) {
                    words.add(word);
                }
            }
        }
        return words;
    }


    public static boolean canWordBeUsed(String word, String playaLettersStr, String pattern, String beginsWith, String endsWith, String mustContain, String mustContainLetters, Integer amountOfBlankTiles, String intersectsWord) {
        //This method checks if a given word can be constructed with the Player's letters and if it starts and ends with optionally specified strings
        if (!patternMatcher.doesStringMatchPatternAndPlayaLetters(word, pattern, playaLettersStr, amountOfBlankTiles)){
            return false;
        }
        if(!canIntersect(word, intersectsWord, playaLettersStr, amountOfBlankTiles)) {
            return false;
        }

        if (pattern.isBlank() && intersectsWord.isBlank()) { // If a pattern is found or a word to be intersected is present, doLettersMatch is executed in patternMatcher or canIntersect
            if (!doLettersMatch(word, playaLettersStr, amountOfBlankTiles)) {
                return false;
            }
        }

        if (!doesBeginningAndEndMatch(word, beginsWith, endsWith)) {
            return false;
        }

        if (!containsPhrase(word, mustContain)) {
            return false;
        }
        if (!containsLetters(word, mustContainLetters)) {
            return false;
        }


        return true;
    }


    public static boolean containsPhrase(String word, String mustContain) {
        if (mustContain == null) {
            return true;
        }
        if (word.contains(mustContain)) {
            return true;
        }
        return false;
    }

    public static boolean containsLetters(String word, String mustContain) {
        if (mustContain == null) {
            return true;
        }

        HashMap<Character, Integer> wordMap = stringToHashMap(word);
        HashMap<Character, Integer> mustContainMap = stringToHashMap(mustContain);

        // Foring through letters in the checked word
        for (Map.Entry<Character, Integer> entry : mustContainMap.entrySet()) {
            int amountOfGivenLetterInWord = wordMap.getOrDefault(entry.getKey(), 0);

            if (amountOfGivenLetterInWord < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean canIntersect(String intersector, String intersectee, String playaLetters, int amountOfBlankTiles) {
        // A checked word can intersect a word from the board if they share at least one letter
        if (intersectee.isBlank()) {
            return true;
        }

        char[] wordFromBoardChars = intersectee.toCharArray();
        for (char c : wordFromBoardChars) {
            if (intersector.contains(String.valueOf(c)) && Algo.doLettersMatch(intersector, playaLetters+c, amountOfBlankTiles)) {
                return true;
            }
        }

        return false;
    }

    public static Stack<Character> stringToCharStack(String str) {
        Stack<Character> out = new Stack<>();
        char[] chars = str.toCharArray();

        for (char ch : chars){
            out.push(Character.valueOf(ch));
        }

        return out;
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

    public static boolean doLettersMatch(String word, String playaLettersStr, Integer amountOfBlankTiles) {
        HashMap<Character, Integer> checkedWord = stringToHashMap(word);
        HashMap<Character, Integer> playaLetters = stringToHashMap(playaLettersStr);

        // Foring through letters in the checked word
        for (Map.Entry<Character, Integer> entry : checkedWord.entrySet()) {
            int amountOfTheCheckedLetterInPlayaLetters = playaLetters.getOrDefault(entry.getKey(), 0); //Checks how many times a given letter is in PlayaLetters

            if ((amountOfTheCheckedLetterInPlayaLetters < checkedWord.get(entry.getKey()))) { // If there isn't enough letters in playaLetters to construct the given word, it will return a false

                if (amountOfTheCheckedLetterInPlayaLetters == 0 && checkedWord.get(entry.getKey()) <= amountOfBlankTiles) { //Unless there's enough blanks. If there is, other letters will be checked
                    amountOfBlankTiles -= checkedWord.get(entry.getKey()) - amountOfTheCheckedLetterInPlayaLetters;
                    continue;
                }
                return false;
            }
        }

        return true;
    }


    public static ArrayList<Scanner> scannersToBeSearched(int constraints) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();

        for (int i = 2; i <= constraints; i++) {
            String pathname = "src\\words" + i + ".txt";
            scannersToBeSearched.add(new Scanner(new FileReader(pathname)));
        }

        return scannersToBeSearched;
    }


    public static int constraints(int space, int amountOfLetters, int patternLength) {
        int[] numbers = {space, amountOfLetters};

        if (patternLength != 0){
            numbers = new int[]{space, amountOfLetters, patternLength};
        }

        Arrays.sort(numbers);

        return numbers[0];
    }

    private static HashMap<Character, Integer> stringToHashMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : word.toCharArray()){
            int occurences = map.getOrDefault(c, 0) + 1;
            map.put(c, occurences);
        }

        return map;
    }

    public static HashMap<Character, Character> twoStringsOfEqualLengthToHashMap(String word1, String word2) {
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
