import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryVet {
    public static void CreateDifferentDictionaries() {
        try{
            File inputFile = new File("src\\vettedDictionary.txt");
            Scanner scanner = new Scanner(inputFile);

            FileWriter words1 = new FileWriter("src\\words1.txt");
            FileWriter words2 = new FileWriter("src\\words2.txt");
            FileWriter words3 = new FileWriter("src\\words3.txt");
            FileWriter words4 = new FileWriter("src\\words4.txt");
            FileWriter words5 = new FileWriter("src\\words5.txt");
            FileWriter words6 = new FileWriter("src\\words6.txt");
            FileWriter words7 = new FileWriter("src\\words7.txt");
            FileWriter words8 = new FileWriter("src\\words8.txt");
            FileWriter words9 = new FileWriter("src\\words9.txt");
            FileWriter words10 = new FileWriter("src\\words10.txt");
            FileWriter words11 = new FileWriter("src\\words11.txt");
            FileWriter words12 = new FileWriter("src\\words12.txt");
            FileWriter words13 = new FileWriter("src\\words13.txt");
            FileWriter words14 = new FileWriter("src\\words14.txt");
            FileWriter words15 = new FileWriter("src\\words15.txt");

            while(scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (word.length() == 2) {
                    words2.append(word+"\n");
                }
                if (word.length() == 3) {
                    words3.append(word+"\n");
                }
                if (word.length() == 4) {
                    words4.append(word+"\n");
                }
                if (word.length() == 5) {
                    words5.append(word+"\n");
                }
                if (word.length() == 6) {
                    words6.append(word+"\n");
                }
                if (word.length() == 7) {
                    words7.append(word+"\n");
                }
                if (word.length() == 8) {
                    words8.append(word+"\n");
                }
                if (word.length() == 9) {
                    words9.append(word+"\n");
                }
                if (word.length() == 10) {
                    words10.append(word+"\n");
                }
                if (word.length() == 11) {
                    words11.append(word+"\n");
                }
                if (word.length() == 12) {
                    words12.append(word+"\n");
                }
                if (word.length() == 13) {
                    words13.append(word+"\n");
                }
                if (word.length() == 14) {
                    words14.append(word+"\n");
                }
                if (word.length() == 15) {
                    words15.append(word+"\n");
                }
            }

            words1.close();
            words2.close();
            words3.close();
            words4.close();
            words5.close();
            words6.close();
            words7.close();
            words8.close();
            words9.close();
            words10.close();
            words11.close();
            words12.close();
            words13.close();
            words14.close();
            words15.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DictionaryVet() {
        try{
            File inputFile = new File("src\\MasterWordList.txt");
            Scanner scanner = new Scanner(inputFile);
            FileWriter outputFile = new FileWriter("src\\vettedDictionary.txt");
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (wordMatchesPattern(word)){
                    outputFile.write(word + "\n");
                }
            }
            outputFile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean wordMatchesPattern(String word){
        if (word.matches("^[a-pr-uwyzęąśżźćółń]{2,15}$")){
            return true;
        }
        return false;
    }

}
