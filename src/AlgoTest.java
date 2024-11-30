import org.junit.Assert;
import org.junit.Test;


public class AlgoTest {

    @Test
    public void foundWords() {

    }

    @Test
    public void testDoesStringMatchGivenLetterPattern(){
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("zupa", "_up_"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("patoloigach", "__t_l__ga__"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("tol", "__t_l__ga__"));
        Assert.assertTrue(Algo.doesStringMatchGivenLetterPattern("cgar", "__t_l__ga__"));

        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("lizg", "__t_l__ga__"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("ślizg", "__t_l__ga__"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("zupa", "_ur_"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("zupa", "jrqwtyi"));

        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("kocioł", "____o_y_______"));
        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("zorz", "____o_y_ł_____"));
//        Assert.assertFalse(Algo.doesStringMatchGivenLetterPattern("okociły", "____o_y_______"));


    }

    @Test
    public void testDoLettersMatch(){
        Assert.assertTrue(Algo.doLettersMatch("aaafginnst", "afganistan", 0));
        Assert.assertTrue(Algo.doLettersMatch("backdown", "abcdknow",0));
        Assert.assertTrue(Algo.doLettersMatch("abcd", "abcd", 0));
        Assert.assertTrue(Algo.doLettersMatch("yzny", "żyzny", 1));

        Assert.assertTrue(Algo.doLettersMatch("laełfł", "fale", 1));

        Assert.assertFalse(Algo.doLettersMatch("yzny", "żyzny", 0));
        Assert.assertFalse(Algo.doLettersMatch("aafginnst", "afganistan", 0));
        Assert.assertFalse(Algo.doLettersMatch("backdow", "abcdknow",0));
        Assert.assertFalse(Algo.doLettersMatch("addd", "abcd", 0));
    }

    @Test
    public void testDoesBeginningAnndEndMatch(){
        Assert.assertTrue(Algo.doesBeginningAndEndMatch("afganistan", "afgani",""));
        Assert.assertTrue(Algo.doesBeginningAndEndMatch("afganistan", "","stan"));

        Assert.assertFalse(Algo.doesBeginningAndEndMatch("afganistan", "","tsan"));
        Assert.assertFalse(Algo.doesBeginningAndEndMatch("afganistan", "fag",""));
    }

    @Test
    public void testContainsMustContain(){
        Assert.assertTrue(Algo.containsMustContain("zupa", "z"));
        Assert.assertTrue(Algo.containsMustContain("zupa", "up"));
        Assert.assertTrue(Algo.containsMustContain("zupa", "zu"));

        Assert.assertFalse(Algo.containsMustContain("zupa", "uz"));
        Assert.assertFalse(Algo.containsMustContain("zupa", "ż"));
        Assert.assertFalse(Algo.containsMustContain("zupa", "pazu"));
    }

    @Test
    public void canWordBeUsed() {
        Assert.assertTrue(Algo.canWordBeUsed("fale", "laełfł", "", "", "", "", 1));

    }
    }