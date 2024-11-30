import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;



public class AlgoTest {

    @Test
    public void foundWords() {

    }

    @Test
    public void testDoesStringMatchGivenLetterPattern2(){
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("zupa", "_up_"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("patoloigach", "__t_l__ga__"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("tol", "__t_l__ga__"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("cgar", "__t_l__ga__"));

        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("lizg", "__t_l__ga__"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("ślizg", "__t_l__ga__"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("zupa", "_ur_"));
    }

    @Test
    public void testDoesCheckedWordContainAtLeastOneLetterFromPattern(){
        Assert.assertTrue(Algo.checkedWordContainsAtLeastOneLetterFromPattern("zupa", "z___"));
        Assert.assertTrue(Algo.checkedWordContainsAtLeastOneLetterFromPattern("zupa", "_up_"));
        Assert.assertTrue(Algo.checkedWordContainsAtLeastOneLetterFromPattern("zupa", "_u__"));


        Assert.assertFalse(Algo.checkedWordContainsAtLeastOneLetterFromPattern("zupa", "jrqwtyi"));
    }

    @Test
    public void canWordBeUsed() {
//        Assert.assertTrue(Algo.canWordBeUsed("afganistan", "aaafginnst", "afgani", "", "","", 0));
//        Assert.assertTrue(Algo.canWordBeUsed("afganistan", "aaafginnst", "", "stan", "","", 0));
//        Assert.assertTrue(Algo.canWordBeUsed("afganistan", "aaafginnst", "", "", "","", 0));
//        Assert.assertTrue(Algo.canWordBeUsed("backdown", "abcdknow", "", "", "","", 0));
//        Assert.assertTrue(Algo.canWordBeUsed("backdowne", "abcdknow", "", "", "","", 1));
//        Assert.assertTrue(Algo.canWordBeUsed("backdowne", "abcdknow", "ba", "", "","", 1));
//        Assert.assertTrue(Algo.canWordBeUsed("backdowne", "abcdknow", "", "ne", "","", 1));
//        Assert.assertTrue(Algo.canWordBeUsed("backdowne", "abcdknow", "", "ne", "","", 2));
//        Assert.assertTrue(Algo.canWordBeUsed("backdownez", "abcdknow", "", "nez", "","", 2));
//
//
//        Assert.assertFalse(Algo.canWordBeUsed("backdown", "abcdkno", "", "", "","", 0));
//        Assert.assertFalse(Algo.canWordBeUsed("afganistan", "aaafginns", "", "", "","", 0));
//        Assert.assertFalse(Algo.canWordBeUsed("francuz", "zucnarf", "fa", "", "","", 0));
//        Assert.assertFalse(Algo.canWordBeUsed("francuz", "zucnarf", "", "az", "","", 0));

    }
    }