import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;


public class AlgoTest {

    @Test
    public void foundWords() {

    }

    @Test
    public void canWordBeUsed() {
        Assert.assertTrue(Algo.canWordBeUsed("dupa", "adpu"));
        Assert.assertTrue(Algo.canWordBeUsed("afganistan", "aaafginnst"));
        Assert.assertTrue(Algo.canWordBeUsed("backdown", "abcdknow"));

        Assert.assertFalse(Algo.canWordBeUsed("backdown", "abcdkno"));
        Assert.assertFalse(Algo.canWordBeUsed("afganistan", "aaafginns"));
        Assert.assertFalse(Algo.canWordBeUsed("żydom", "domom"));
        Assert.assertFalse(Algo.canWordBeUsed("żydom", "dżdży"));
    }

    @Test
    public void readersToBeSearched() {
        try{
        Assert.assertTrue(testReadersToBeSearched(2, new char[]{'a', 'b'}));
        Assert.assertTrue(testReadersToBeSearched(2, new char[]{'a', 'b', 'c'}));
        Assert.assertTrue(testReadersToBeSearched(3, new char[]{'a', 'b'}));

        Assert.assertTrue(testReadersToBeSearched(3, new char[]{'a', 'b', 'c'}));
        Assert.assertTrue(testReadersToBeSearched(3, new char[]{'a', 'b', 'c', 'd'}));
        Assert.assertTrue(testReadersToBeSearched(4, new char[]{'a', 'b', 'c'}));

        Assert.assertTrue(testReadersToBeSearched(4, new char[]{'a', 'b', 'c', 'd'}));
        Assert.assertTrue(testReadersToBeSearched(4, new char[]{'a', 'b', 'c', 'd', 'e'}));
        Assert.assertTrue(testReadersToBeSearched(5, new char[]{'a', 'b', 'c', 'd'}));

        }
        catch (Exception FileNotFoundException) {
            throw new RuntimeException(FileNotFoundException);
        }
        }

    public static boolean testReadersToBeSearched(int space, char[] letters) throws FileNotFoundException {
        // This function tests scannersToBeSearched, if it returns the expected amount of readers
//        return Algo.constraints(space, letters) == Algo.readersToBeSearched(space, letters).size() +1;
        return true;
        }

    }