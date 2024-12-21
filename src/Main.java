import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        //TODO: Write a function that will take a word from the board and come up with a word that touches it, but does not intersect it.
        //The new word would butt the word from board, requiring to make up a new word from playaLetters, that creates a new word with word from the board

        //TODO: Write a function that will calculate how many points a given word would yield

        try{
//            ArrayList<String> wordsForOutput = Algo.output("ofśbmou", "", "_____y___i_____", "", "", "", "", 15, 0);
            ArrayList<String> wordsForOutput = Algo.output("ofśbmou", "i", "", "", "", "", "", 15, 0);
            for (String word : wordsForOutput){

                System.out.println(word + " " + word.length());
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
_
_
Where "_" are unused tiles.
The next step for this code is to accept patterns that represent such cases and searching for words that would incorporate the letters from the board.
That function wouldn't need to care if a found word would be made out of player's letters, because that would be assured by another function
(which in takes in player's and board letters as input in no particular order).

The pattern for the example described above would look like this:
2A1B2C0D2
With letters representing board letters and numbers representing space between them

Just because a letter is provided doesn't mean that it HAS to be used.
If a word was to be found that would incorporate some letters but not others, with which it would not interfere, the word should receive a pass.
Illustrating with the example above, if a word that followed the pattern {.}*A.B{.}? were to be found, it would pass

How to check if a string matches a given pattern, attempt three:
The first attempt was never finished and the approach from the second attempt doesn't work very well, at least partially.
The logic for a pattern that's the same length as the word seems to work alright, so it's going to be reused in the third attempt.
So, how to check if the length differs? Here's how:
- set up a fori, which has a limit of (pattern length-word length)
- provide the "pattern length matches word length" function with a segment of the pattern, from i to (i+word length).
- if one is true, return true.

One more problem needs to be solved. Because playerLetters gets supplied with letters from pattern, sometimes words pass when they shouldn't.
These false positives contain letters from the pattern, even when the word doesn't make contact with them.
This happens because the function "output" adds all letters from the pattern to playerLetters, even though some letters don't end up being used.

How to check if a string matches a given pattern, attempt two:
The pattern should actually look like __A_B__CD__
- The pattern should be longer than or equal to the checked word, so if that condition isn't met, return false. DONE
- If at least one of the letters from the pattern (stripped of off "_") isn't in the word, the word cannot be used DONE
- If the pattern and the checked word are of the same length:
    - True:
        - Convert the checked word and the pattern the into a HashMap<Character, Character>. DONE
        - For through all the letters in the checked word, DONE
        - Check if their Values match Keys (Characters from the pattern) or "_" DONE
            - False - return false; DONE
        - All Characters from the word matched the pattern's letters or "_"s, return true; DONE
    - False:
        - For through the pattern
        - Check if i and i+checkedWord.length are "_"
            - False: continue;
            - True: plug a segment of the pattern starting at i+1 and ending at i+checkedWord.length-1 into doesCheckedWordMatchPatternOfSameLength
 */

/*
Sometimes, when a pattern is supplied, the method canWordBeUsed returns false positives.

Algo.canWordBeUsed is made up of several functions, returning "false" if a word doesn't match their criteria.
patternMatcher lets words through if they match a pattern, with complete disregard to if a word can be constructed using playaLetters.
Algo.doLettersMatch checks if a word can be constructed with the given letters, of which letters from pattern are a part of.
That's the root of the cause. patternMatcher provided with a pattern "_a_b__" would naturally let a word "bao" through, as it's supposed to.
playaLetters would be appended with "ab", and if the player holds the letter "o" and the word "bao" would be outputted, even though it cannot actually be constructed.

How to stop canWordBeUsed from returning false positives:
If a pattern is provided, checking doLettersMatch to be omitted and its task to be outsourced to patternMatcher.
That way patternMatcher.doesCheckedWordMatchPatternOfSameLength could check if the current word could be made out of playaLetters+lettersFromPatternFragment.

*/