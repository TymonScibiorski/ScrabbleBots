import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try{
            ArrayList<String> wordsForOutput = Algo.output(10, "żeyodz");
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

//How to check if a word is made of letters:
//1. Sort the given list and assign the number of times a given letter, on a seperate function
//2.

/*
How to check if a word is made out of the given letters, by Wojtek:
1.
 */
