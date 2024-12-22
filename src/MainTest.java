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
    public void testConstrainsNew(){
        Assert.assertEquals(4, Algo.constraintsNew("zupatży", "_u__", "ulep", 2));
        Assert.assertEquals(2, Algo.constraintsNew("afganistan", "_a", "zupa", 0));
        Assert.assertEquals(15, Algo.constraintsNew("rrrrrrr", "a_a_a_a_a_a_a_a", "", 0));

        Assert.assertEquals(7, Algo.constraintsNew("rrrrrrr", "", "", 0));
        Assert.assertEquals(8, Algo.constraintsNew("rrrrrrr", "_______a", "", 0));

//        Assert.assertEquals();

//        Assert.assertEquals(15, Algo.constraints(,15,15));
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
        Assert.assertTrue(Algo.canWordBeUsed("fale", "laełfł", "", "", "", "", "", 1, ""));
        Assert.assertTrue(Algo.canWordBeUsed("fale", "laełfł", "__f__e__", "f", "e", "f", "l", 1, "taflę"));
        Assert.assertTrue(Algo.canWordBeUsed("zad", "oęfypad", "", "", "", "", "", 0, "zbi"));


        Assert.assertFalse(Algo.canWordBeUsed("rozwodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("rdze", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("rdzo", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("rzez", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("zorz", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("zwodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("zrodzeń", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("dozorze", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("zworze", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("wzorze", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
        Assert.assertFalse(Algo.canWordBeUsed("ozorze", "rowoeńk", "_______z__d____", "", "", "","", 0, ""));
    }

    @Test
    public void testCanIntersect(){
        Assert.assertTrue(Algo.canIntersect("dinozaur", "dinozaury", "dinoaur", 0));
        Assert.assertTrue(Algo.canIntersect("dinozaur", "dinozaury", "dinozur", 0));
        Assert.assertTrue(Algo.canIntersect("zad", "zbi", "ad", 0));
        Assert.assertTrue(Algo.canIntersect("zad", "zbi", "oęfypad", 0));
        Assert.assertTrue(Algo.canIntersect("zd", "zbi", "oęfypad", 1));
//        Assert.assertTrue(Algo.canIntersect("", "", "", 0));

        Assert.assertFalse(Algo.canIntersect("burza", "lity", "burza", 0));
        Assert.assertFalse(Algo.canIntersect("zupa", "tlić", "zupa", 1));
//        Assert.assertFalse(Algo.containsAtLeastOneLetterFrom("", ""));
    }
    }