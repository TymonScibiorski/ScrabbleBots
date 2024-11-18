import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AlgoTest {

    @Test
    public void foundWords() {

    }

    @Test
    public void scannersToBeSearched() {
        boolean forAssertion = true;

        try {
            ArrayList<Scanner> scannersToBeTested = Algo.scannersToBeSearched(3, new char[]{'a', 'b', 'c'});

            for (int i = 3; i > 1; i--) {
                Scanner sureScanner = new Scanner(new File("src\\words"+ String.valueOf(i) +".txt"));
                Scanner unsureScanner = scannersToBeTested.get(i);
                while (unsureScanner.hasNextLine()) {
                    if (unsureScanner.nextLine() != sureScanner.nextLine()) {
                        forAssertion = false;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            }
        }

        Assert.assertTrue(forAssertion);
    }