import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Butts {
//    private String[] words2;
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

    public static String[] createWordList(int wordLength) throws IOException {
        String filePath = Algo.pathNameGenerator(wordLength);
        BufferedReader bf = getBufferedReader(filePath);

        return BufferedReaderToStringArray(bf);
    }

    public static BufferedReader getBufferedReader(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }

    public static String[] BufferedReaderToStringArray(BufferedReader bf) throws IOException {
        List<String> listOfStrings = new ArrayList<String>();
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        return listOfStrings.toArray(new String[0]);
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
Prefix and suffix it with each single letter from the tested word, creating a list of new Strings.
Test all the resulting String with doesWordExist. If at least one returns true, return true.
Otherwise, return false.

Second way:

Scheme drawn, time to write it here.
TODO: Write the thought process for this function


The function doesWordExist has to be really fast. It will be used many times for a single set of words, binarySearch and memoisation is to be implemented.
Word list "words2.txt" will be used always and many times over, so it should be kept in memory.


 */
