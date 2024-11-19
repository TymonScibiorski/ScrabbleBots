import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class AlgoTest {

    @Test
    public void foundWords() {

    }

    @Test
    public void scannersToBeSearched() {
        Assert.assertTrue(testScannersToBeSearched(2, new char[]{'a', 'b'}));
        Assert.assertTrue(testScannersToBeSearched(2, new char[]{'a', 'b', 'c'}));
        Assert.assertTrue(testScannersToBeSearched(3, new char[]{'a', 'b'}));

        Assert.assertTrue(testScannersToBeSearched(3, new char[]{'a', 'b', 'c'}));
        Assert.assertTrue(testScannersToBeSearched(3, new char[]{'a', 'b', 'c', 'd'}));
        Assert.assertTrue(testScannersToBeSearched(4, new char[]{'a', 'b', 'c'}));

        Assert.assertTrue(testScannersToBeSearched(4, new char[]{'a', 'b', 'c', 'd'}));
        Assert.assertTrue(testScannersToBeSearched(4, new char[]{'a', 'b', 'c', 'd', 'e'}));
        Assert.assertTrue(testScannersToBeSearched(5, new char[]{'a', 'b', 'c', 'd'}));
        }

    public static boolean testScannersToBeSearched(int space, char[] chars) {
        boolean forAssertion = true;

        try {
            ArrayList<Scanner> scannersToBeTested = Algo.scannersToBeSearched(space, chars);
            int constraints = Algo.constraints(space, chars);

            for (int i = 1; i < constraints; i++) {
                String pathname = "src\\words"+ i +".txt";
                Scanner sureScanner = new Scanner(new File(pathname));
                Scanner unsureScanner = scannersToBeTested.get(i-1);
                while (unsureScanner.hasNextLine()) {
                    if (!Objects.equals(unsureScanner.nextLine(), sureScanner.nextLine())) {
                        forAssertion = false;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return forAssertion;
    }
    }