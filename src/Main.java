public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        DictionaryVet.DictionaryVet();
        DictionaryVet.CreateDifferentDictionaries();

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
//3. For through letters
//4. Check if the word is made of letters

//How to check if a word is made of letters:
//1.
