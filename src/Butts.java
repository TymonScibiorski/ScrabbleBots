public class Butts {
//    private String[] dictionary2;
//
//
//    public boolean doesWordExist(){
//        // This function has much room for improvement. Since it will be used many times, a class could be created, which would hold the dictionary, allowing it bo be binarySearched.
//    }
    public boolean doesWordExist(String word) {
        int wordLength = word.length();
        String[] appropriateWordList = appropriateWordList(wordLength);

        return wordInWordList(word, appropriateWordList);
    }

    public static boolean wordInWordList(String word, String[] wordList) {
        return false;
        // Implement binary search.
    }

    public static String[] appropriateWordList(int wordLength) {
        return new String[wordLength];
        // If (wordList) == null -> return new
        // Else -> return the existing one
    }
}

/*
The Butts function takes IN a word from the board, in this documentation forward called "set word" and a tested word.
OUTPUT is a boolean value:
TRUE is returned when the tested word can butt up against the set word, not intersecting it, creating two new words.
FALSE is returned otherwise.

The Butts function fundamentally works in TWO different ways:
FIRST WAY green-lights a word that would lie perpendicularly to the set word.
SECOND WAY green-lights a word that would lie parallel to the set word.

First way:
Take the set word
Prefix and suffix it with each single letter from playaLetters.
Open up a dictionary of set word .length() +1 and test if all words resulting from the previous step exist.
If at least one exists, return true.
Otherwise, return false.

Second way:


 */
