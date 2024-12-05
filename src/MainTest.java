import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    public void foundWords() {

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
    public void testConstrains(){
        Assert.assertEquals(1, Algo.constraints(1,2,3));
        Assert.assertEquals(2, Algo.constraints(2,3,4));
        Assert.assertEquals(0, Algo.constraints(0,16,4));
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