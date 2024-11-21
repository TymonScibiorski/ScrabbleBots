import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try{
            ArrayList<String> wordsForOutput = Algo.output(14, "upad", "");
            for (String word : wordsForOutput){

                System.out.println(word);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");


       }
    }

//Scrabble bot:
//
//Constraints:
//1. Given letters
//2. Dictionary
//3. Space

// Goals:
// Has to dispense out words that can be created with given letters and within a determined, confined space. Doesn't need to be fast nor resourceful.

//Pre steps:
// Vet the dictionary, sort words by length and throw out words longer than 15 letters long. DONE

//Steps:
//1. Throw out words that are longer than the space given or amount of letters given DONE
//2. For through dictionary
//3. Check if the word is made of the given letters
//4. Return a list of words that from the dictionary that were made out of the given letters and fitted in the confined space


/*
How to check if a word is made out of the given letters:
1. Parse the checked word and the given letters to a hashmap DONE
2. For through letters from the checked word: DONE
3. Take a single letter from the checked word. DONE
4. Check if the single letter from the checked word appears in the given letters set. If it doesn't, return false. DONE
5. Get the amount of the approved letter in the player's letters set. DONE
6. Get the amount of the approved letter in the checkWord set. DONE
7. If the amount from the 5th point is smaller than the amount from the 6th, return false. DONE
6. Return true. DONE
 */
