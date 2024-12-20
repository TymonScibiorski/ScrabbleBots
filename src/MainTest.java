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
        Assert.assertTrue(Algo.doLettersMatch("fale", "laełfł", 1));

        Assert.assertFalse(Algo.doLettersMatch("żyzny", "yzny",0));
        Assert.assertFalse(Algo.doLettersMatch( "afganistan", "aafginnst",0));
        Assert.assertFalse(Algo.doLettersMatch( "abcdknow","backdow",0));
        Assert.assertFalse(Algo.doLettersMatch( "abcd", "addd",0));
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
        Assert.assertEquals(15, Algo.constraints(15,15,15));
    }

    @Test
    public void testContainsPhrase(){
        Assert.assertTrue(Algo.containsPhrase("zupa", "z"));
        Assert.assertTrue(Algo.containsPhrase("zupa", "up"));
        Assert.assertTrue(Algo.containsPhrase("zupa", "zu"));
        Assert.assertTrue(Algo.containsPhrase("zupa", "zup"));
        Assert.assertTrue(Algo.containsPhrase("zupa", "zupa"));

        Assert.assertFalse(Algo.containsPhrase("zupa", "uz"));
        Assert.assertFalse(Algo.containsPhrase("zupa", "ż"));
        Assert.assertFalse(Algo.containsPhrase("zupa", "pazu"));
    }

    @Test
    public void testContainsLetters(){
        Assert.assertTrue(Algo.containsLetters("zupa", "z"));
        Assert.assertTrue(Algo.containsLetters("zupa", "zu"));
        Assert.assertTrue(Algo.containsLetters("zupa", "zup"));
        Assert.assertTrue(Algo.containsLetters("zupa", "zupa"));
        Assert.assertTrue(Algo.containsLetters("zupa", "uz"));
        Assert.assertTrue(Algo.containsLetters("zupa", "puz"));
        Assert.assertTrue(Algo.containsLetters("zupa", "pzu"));
        Assert.assertTrue(Algo.containsLetters("zupa", "apuz"));
        Assert.assertTrue(Algo.containsLetters("zupa", ""));

        Assert.assertFalse(Algo.containsLetters("zupa", "apuzx"));
        Assert.assertFalse(Algo.containsLetters("zupa", "puzx"));
        Assert.assertFalse(Algo.containsLetters("afganistan", "aaaa"));
    }

    @Test
    public void canWordBeUsed() {
        Assert.assertTrue(Algo.canWordBeUsed("fale", "laełfł", "", "", "", "", "", 1));

        Assert.assertFalse(Algo.canWordBeUsed("rozwodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("rdze", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("rdzo", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("rzez", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("zorz", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("zwodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("zrodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("dozorze", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("zworze", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("wzorze", "rowoeńk", "_______z__d____", "", "", "","", 0));
        Assert.assertFalse(Algo.canWordBeUsed("ozorze", "rowoeńk", "_______z__d____", "", "", "","", 0));
        // The tests above returns the expected value - false - but for the word still made it to the output!

    }

    @Test
    public void testcontainsAtLeastOneLetterFrom(){
        Assert.assertTrue(Algo.containsAtLeastOneLetterFrom("zupa", "dinozaur"));
        Assert.assertTrue(Algo.containsAtLeastOneLetterFrom("dinozaur", "dinozaury"));
//        Assert.assertTrue(Algo.containsAtLeastOneLetterFrom("", ""));

        Assert.assertFalse(Algo.containsAtLeastOneLetterFrom("burza", "lity"));
        Assert.assertFalse(Algo.containsAtLeastOneLetterFrom("zupa", "tlić"));
//        Assert.assertFalse(Algo.containsAtLeastOneLetterFrom("", ""));
    }
    }