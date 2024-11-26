import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try{
            ArrayList<String> wordsForOutput = Algo.output("al", "", "", "", 15, 0);
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

/*
Sometimes in scrabble tiles placed by players can have space in between.
Placing words that use those letters is allowed and even crucial in a way, once a game gets complex enough.
So sometimes the board looks like this:
_
_
A
_
B
_
_
C
D
Where "_" are unused tiles.
The next step for this code is to accept patterns that represent such cases and searching for words that would incorporate the letters from the board.
That function wouldn't need to care if a found word would be made out of player's letters, because that would be assured by another function
(which in takes in player's and board letters as input in no particular order).

The pattern for the example described above would look like this:
2A1B2C0D
With letters representing board letters and numbers representing space between them

Just because a letter is provided doesn't mean that it HAS to be used.
If a word was to be found that would incorporate some letters but not others, with which it would not interfere, the word should receive a pass.
Illustrating with the example above, if a word that followed the pattern {.}*A.B{.}? were to be found, it would pass

How to check if a string matches a given pattern:
- For through letters of the checked word.
- Check if the given letter matches one of the pattern's letters.
    - If none are found, return false.
    - If one letter form the pattern is found, call it "X", check if it's the first in the given pattern
        - If X is the first:
            - Check if the amount of letters preceding X is smaller than the number before it. For the example pattern: if it has three letters before "A.B", then it's start is too long and must be discarded.
                - If it's bigger: return false
                - If it's smaller: continue
        - If X isn't the first in the given pattern, check if the number preceding X is 0 or more than 0, call it N-1.
            -If N-1 is zero, then some letter from the given pattern should have preceded X, but it wasn't found, therefore it is not there and the word cannot be used: return false. For the example pattern: if a "D" is found, but "C" has not, the word can't be used
            -If N-1 is more than zero, then check if less than N-1 letters precede X. For the example pattern: a word that has zero letters before "B" or one letter before "C", then it can be accepted
                -If more than N-1 letters precede X, then it isn't one from the specified pattern:return false
                -If less than N-1 letters precede X, continue
    - (If) Compare the amount of letters succeeding X to the number succeeding X in the pattern, call it N1
        - If it's smaller: return true.
        - If it's equal: return false. For the example a word that ends in "A.B.." wouldn't contain the necessary "CD"
        - While it's bigger:
            - Jump ahead N1 amount of letters ahead and check if it matches the new X
            - Repeat the last If

 */