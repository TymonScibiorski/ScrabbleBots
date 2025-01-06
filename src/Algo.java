import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algo {


    public static ArrayList<String> output(String lettersStr, String intersectsWord, String pattern, String mustContainPhrase, String beginsWith, String endsIn, String mustContainLetters, Integer amountOfBlankTiles) throws IOException {
        StringBuilder playaLetters = new StringBuilder(lettersStr + mustContainLetters + beginsWith + endsIn);

        return foundWords(String.valueOf(playaLetters), pattern, beginsWith, endsIn, mustContainPhrase, mustContainLetters, amountOfBlankTiles, intersectsWord);
    }

    //The code commented out below is to be a remake of foundWords to work on Stack and a function that would calculate how many points a given word would yield.

//    public static Stack<String> foundWordsNew(String playaLetters, String pattern, String beginsWith, String endsWith, String mustContain, String mustContainLetters, Integer amountOfBlankTiles, String intersectsWord) throws IOException {
//        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
//        Stack<String> words = new Stack<>();
////        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
//        ArrayList<Scanner> scanners = scannersToBeSearched(constraintsNew(playaLetters, pattern, intersectsWord, amountOfBlankTiles));
//
//        for (Scanner scanner : scanners) {
//            while (scanner.hasNextLine()) {
//                String word = scanner.nextLine();
//
//                if (canWordBeUsed(word, playaLetters, pattern, beginsWith, endsWith, mustContain, mustContainLetters, amountOfBlankTiles, intersectsWord)) {
//                    words.add(word);
//                }
//            }
//        }
//        return words;
//    }
//
//    public static int pointsForWord(String word) {
//        int points = 0;
//        HashMap<Character, Integer> letterDictionary = new HashMap<>();
//        letterDictionary.put('a', 1);
//
//        return points;
//    }
//
//    public static int pointsForLetter(char letter) {
//        if (letter == '0'){
//            return 0;
//        }
//
//
//    }

//    public static ArrayList<String> foundWordsOnReaders(String playaLetters, String pattern, String beginsWith, String endsWith, String mustContain, String mustContainLetters, Integer amountOfBlankTiles, String intersectsWord) throws IOException {
//        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
//        int constraints = constraints(playaLetters, pattern, intersectsWord, amountOfBlankTiles);
//        Stream<String> dataFromAppropriateDictionaries = streamToSearch(constraints);
//
//        return dataFromAppropriateDictionaries
//                .filter(word -> canWordBeUsed(word, playaLetters, pattern, beginsWith, endsWith, mustContain, mustContainLetters, amountOfBlankTiles, intersectsWord))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }

    public static ArrayList<String> foundWords(String playaLetters, String pattern, String beginsWith, String endsWith, String mustContain, String mustContainLetters, Integer amountOfBlankTiles, String intersectsWord) throws IOException {
        // This function searches wordlists and finds words that could be constructed with the given letters in the given space.
//        ArrayList<BufferedReader> readers = readersToBeSearched(space, letters);
        ArrayList<String> words = new ArrayList<>();
        int constraints = constraints(playaLetters, pattern, intersectsWord, amountOfBlankTiles);
        ArrayList<Scanner> scanners = scannersToBeSearched(constraints);


        for (Scanner scanner : scanners) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                if (canWordBeUsed(word, playaLetters, pattern, beginsWith, endsWith, mustContain, mustContainLetters, amountOfBlankTiles, intersectsWord)) {
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

    public static boolean beginningMatches(String word, String beginsWith) {
        if (beginsWith.length() > word.length()) {
            return false;
        }

        for (int i = 0; i < beginsWith.length(); i++) {
            if (beginsWith.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean endMatches(String word, String endsWith){
        if (endsWith.length() > word.length()) {
            return false;
        }

        for (int i = 0; i < endsWith.length(); i++) {
            // Has to start from the beginning of the end of the word and beginning of endsWith
            if (endsWith.charAt(i) != word.charAt(word.length() - endsWith.length() + i)) {
                return false;
            }
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
            String pathname = pathNameGenerator(i);
            scannersToBeSearched.add(new Scanner(new FileReader(pathname)));
        }

        return scannersToBeSearched;
    }


    public static int constraints(String playaLettres, String pattern, String intersectsWord, int amountOfBlankTiles) {
        String allAvailableLetters = playaLettres + pattern.replace("_", "");
        int wordMaxLength = allAvailableLetters.length()+amountOfBlankTiles;
        if (!(intersectsWord.isBlank())){
            wordMaxLength += 1;
        }


        if (!pattern.isBlank() && wordMaxLength > pattern.length()) {
            wordMaxLength = pattern.length();
        }

        if (wordMaxLength > 15) {
            wordMaxLength = 15;
        }

        return wordMaxLength;
    }

    public static HashMap<Character, Integer> stringToHashMap(String word) {
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

//    public static Stream<String> readersToBeSearched(int constraints) throws FileNotFoundException {
//        // This function returns scanners of wordlists that will be searched through to find words that could be constructed with the given letters in the given space.
//        ArrayList<BufferedReader> readersToBeSearched = new ArrayList<>();
//
//        for (int i = constraints; i > 1; i--) {
//            String pathname = "src\\words" + i + ".txt";
//            readersToBeSearched.add(new BufferedReader(new FileReader(pathname)));
//        }
//
//        return readersToBeSearched.stream();
//    }

//    public static Stream<String> streamToSearch(int constraints) throws FileNotFoundException {
//        return
//    }

    public static BufferedReader readerOfWordList(int wordListNumber) throws FileNotFoundException {
        return new BufferedReader(new FileReader(pathNameGenerator(wordListNumber)));
    }

    public static String pathNameGenerator(int wordListNumber){
        if (1<wordListNumber && wordListNumber<16) {
            return "src\\words" + wordListNumber + ".txt";
        }
        return "";
    }
}
