import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Algo {
    public static ArrayList<String> output(String lettersStr,  String mustContain, String pattern,String beginsWith, String endsIn, int space, Integer amountOfBlankTiles) throws IOException {
        lettersStr += mustContain + beginsWith + endsIn + pattern.replace("_", "");

        return foundWords(space, lettersStr, pattern, beginsWith, endsIn, mustContain, amountOfBlankTiles);
    }


    public static ArrayList<String> foundWords(int space, String letters, String pattern, String beginsWith, String endsWith, String mustContain, Integer amountOfBlankTiles) throws IOException {
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
        ArrayList<String> words = new ArrayList<>();
//        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
        ArrayList<Scanner> scanners = scannersToBeSearched(constraints(space, letters.length(), pattern.length()), amountOfBlankTiles);

        for (Scanner scanner : scanners) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                if (canWordBeUsed(word, letters, pattern, beginsWith, endsWith, mustContain, amountOfBlankTiles)) {
                    words.add(word);
                }
            }
        }
        return words;
    }


    public static boolean canWordBeUsed(String word, String playaLettersStr, String pattern, String beginsWith, String endsWith, String mustContain, Integer amountOfBlankTiles) {
        //This method checks if a given word can be constructed with the Player's letters and if it starts and ends with optionally specified strings
        if (!doLettersMatch(word, playaLettersStr, amountOfBlankTiles)) {
            return false;
        }

        if (!doesBeginningAndEndMatch(word, beginsWith, endsWith)) {
            return false;
        }

        if (!containsMustContain(word, mustContain)) {
            return false;
        }

        if (!pattern.isBlank() && !doesStringMatchGivenLetterPattern(word, pattern)){
            return false;
        }

        return true;

    }

//    public static boolean doesStringMatchGivenLetterPattern3(String word, String usersPattern){
//        for (int i = 0; i < usersPattern.length() - word.length(); i++) {
//
//
//        }
//
//        return true;
//    }

    public static boolean doesStringMatchGivenLetterPattern(String word, String usersPattern){
        // Sometimes dysfunctions, because HashMaps are used, and if a letter occurs more than once, a previous value is overwritten.
        if (usersPattern.length() < word.length()){
            return false;
        }
        if (!checkedWordContainsAtLeastOneLetterFromPattern(word, usersPattern)){
            return false;
        }

        if (usersPattern.length() == word.length()) {
            return doesCheckedWordMatchPatternOfSameLength(word, usersPattern);
        }

        char[] patternChar = usersPattern.toCharArray();

        for (int i = 0; i < patternChar.length-word.length()-1; i++) {
            char currentChar = patternChar[i];
            char charAfterWord = patternChar[i+word.length()+1];
            if(isLetter(currentChar)) {
                continue;
            }
            if(isLetter(charAfterWord)){
                continue;
            }

            String fragmentOfPattern = new String(Arrays.copyOfRange(patternChar, i+1, i+word.length()+1));
            if(fragmentOfPattern.matches("^_+$")){ // If the new-found pattern doesn't contain any letters from the original pattern, then it cannot be used
                continue;
            }

            if (doesCheckedWordMatchPatternOfSameLength(word, fragmentOfPattern)) {
                return true;
            }
        }

        return false;
    }

//    public static boolean foundPatternIsntJust_()

    public static boolean isLetter(char letter) {
        return Character.isLetter(letter);
    }

    public static boolean doesCheckedWordMatchPatternOfSameLength(String word, String usersPattern){
//        HashMap<Character, Character> wordAndPatternMap = twoStringsOfEqualLengthToHashMap(word, usersPattern);
//
//        for (Map.Entry<Character, Character> entry : wordAndPatternMap.entrySet()) {
//            if (!(entry.getValue().equals(entry.getKey())  || entry.getValue().equals('_'))) {
//                return false;
//            }
//        }
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) == usersPattern.charAt(i) || usersPattern.charAt(i) == '_')) {
                return false;
            }

        }

        return true;
    }

    public static ArrayList<String> somethingOfAMap(String word, String usersPattern){
        ArrayList<String> out = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            out.add(new String(String.valueOf(word.charAt(i)+usersPattern.charAt(i))));
        }

        return out;
    }

    public static boolean checkedWordContainsAtLeastOneLetterFromPattern(String word, String usersPattern){
        char[] usersPatternArray = usersPattern.replace("_", "").toCharArray();
        for (char c : usersPatternArray) {
            if(word.contains(String.valueOf(c))){
                return true;
            }
        }

        return false;
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


    public static ArrayList<Scanner> scannersToBeSearched(int constraints, Integer amountOfBlankTiles) throws FileNotFoundException {
        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
        ArrayList<Scanner> scannersToBeSearched = new ArrayList<>();

        for (int i = 2; i <= constraints+amountOfBlankTiles; i++) {
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
