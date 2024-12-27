import java.util.HashMap;
import java.util.Map;

public class canWordBeBuildFromLetters {

    private static void createPlayaLettersHashMap(String playaLetters) {
        HashMap<Character, Integer> playaLettersHashMap = Algo.stringToHashMap(playaLetters);
    }

    public boolean doLettersMatch(String word, HashMap<Character, Integer> playaLetters, Integer amountOfBlankTiles) {
        HashMap<Character, Integer> checkedWord = Algo.stringToHashMap(word);

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
}
