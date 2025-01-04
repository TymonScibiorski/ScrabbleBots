import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class MainTest {

    @Test
    public void foundWords() throws IOException {
        String[] strArr1 =new String[]{"em", "me"};
        ArrayList<String> strArr2 = Algo.foundWords("me","", "", "", "", "", 0, "");
        Assert.assertTrue(areStrArrsSame(strArr1, strArr2));

        strArr1 = new String[]{"aa","ag","as","at","fa","fi","in","na","ni","si","ta","ts","aaa","aft","aga","agi","ais","ana","ani","ans","ant","asa","ata","fag","fai","fan","fas","fig","fin","fis","fit","gaf","gai","gan","gif","gin","gis","git","gna","inf","nai","nas","nat","nit","sag","sia","sit","taf","tag","tai","tan","tas","afta","agan","agat","agia","ansa","anta","asan","faga","fagi","fana","fang","fani","fant","fasa","fata","fiat","figa","fina","finn","fint","fita","gafa","gana","gani","gasi","gifa","gina","gita","gnat","infa","inna","naan","naft","naga","nagi","nasi","nata","ngan","nita","saga","sagi","sani","sann","sati","sian","siat","sina","sita","snif","staf","stai","stan","tafa","taga","tagi","tana","tang","tani","afgan","agnat","angin","angst","annat","asana","asani","fagas","fagin","fanga","fangi","fanta","fasti","finna","finta","gania","gitan","gitna","gnana","gnani","gnata","istna","naana","nafta","nagan","nagna","nasta","natia","ngana","nisan","sagan","sanna","siana","siata","signa","tafia","tagin","tanga","tangi","tania","tanin","afagia","afgana","afgani","aganin","agatis","agnata","ananas","angina","asania","fagasa","fagasi","fagina","gitana","gnania","infant","nagana","nagina","nastia","nisana","safian","sagana","satang","stania","stanin","tagina","tanina","aganina","agatisa","ganiana","infanta","nagania","naginat","nasiana","satanga","satangi","stanina","naginata","nagniata","nastania","saignant",};
        strArr2 = Algo.foundWords("afganistan","", "", "", "", "", 0, "");
        Assert.assertTrue(areStrArrsSame(strArr1, strArr2));
    }

    public static boolean areStrArrsSame(String[] arr1, ArrayList<String> arr2) {
        for (int i = 0; i < (arr1.length+ arr2.size())/2; i++) {
            if (!(arr1[i].equals(arr2.get(i)))) {
                return false;
            }
        }
        return true;
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
    public void testDoesBeginningAndEndMatch(){
        Assert.assertTrue(Algo.doesBeginningAndEndMatch("afganistan", "afgani",""));
        Assert.assertTrue(Algo.doesBeginningAndEndMatch("afganistan", "","stan"));

        Assert.assertFalse(Algo.doesBeginningAndEndMatch("afganistan", "","tsan"));
        Assert.assertFalse(Algo.doesBeginningAndEndMatch("afganistan", "fag",""));
    }

    @Test
    public void testDoesBeginningMatch(){
        Assert.assertTrue(Algo.beginningMatches("abba", "a"));
        Assert.assertTrue(Algo.beginningMatches("abba", "ab"));
        Assert.assertTrue(Algo.beginningMatches("abba", "abb"));
        Assert.assertTrue(Algo.beginningMatches("abba", "abba"));

        Assert.assertFalse(Algo.beginningMatches("abba", "b"));
        Assert.assertFalse(Algo.beginningMatches("abba", "ba"));
        Assert.assertFalse(Algo.beginningMatches("abba", "bba"));
    }

    @Test
    public void testDoesEndMatch(){
        Assert.assertTrue(Algo.endMatches("abba", "a"));
        Assert.assertTrue(Algo.endMatches("abba", "ba"));
        Assert.assertTrue(Algo.endMatches("abba", "bba"));
        Assert.assertTrue(Algo.endMatches("abba", "abba"));

        Assert.assertFalse(Algo.endMatches("abba", "b"));
        Assert.assertFalse(Algo.endMatches("abba", "bb"));
        Assert.assertFalse(Algo.endMatches("abba", "abb"));
    }

    @Test
    public void testConstrains(){
        Assert.assertEquals(4, Algo.constraints("zupatży", "_u__", "ulep", 2));
        Assert.assertEquals(2, Algo.constraints("afganistan", "_a", "zupa", 0));
        Assert.assertEquals(15, Algo.constraints("rrrrrrr", "a_a_a_a_a_a_a_a", "", 0));

        Assert.assertEquals(7, Algo.constraints("rrrrrrr", "", "", 0));
        Assert.assertEquals(8, Algo.constraints("rrrrrrr", "_______a", "", 0));

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

    @Test
    public void testPathNameGenerator(){
        Assert.assertEquals("", Algo.pathNameGenerator(0));
        Assert.assertEquals("", Algo.pathNameGenerator(1));
        Assert.assertEquals("", Algo.pathNameGenerator(16));
        Assert.assertEquals("", Algo.pathNameGenerator(17));


        Assert.assertEquals("src\\words2.txt", Algo.pathNameGenerator(2));
        Assert.assertEquals("src\\words3.txt", Algo.pathNameGenerator(3));
        Assert.assertEquals("src\\words4.txt", Algo.pathNameGenerator(4));
        Assert.assertEquals("src\\words5.txt", Algo.pathNameGenerator(5));
        Assert.assertEquals("src\\words6.txt", Algo.pathNameGenerator(6));
        Assert.assertEquals("src\\words7.txt", Algo.pathNameGenerator(7));
        Assert.assertEquals("src\\words8.txt", Algo.pathNameGenerator(8));
        Assert.assertEquals("src\\words9.txt", Algo.pathNameGenerator(9));
        Assert.assertEquals("src\\words10.txt", Algo.pathNameGenerator(10));
        Assert.assertEquals("src\\words11.txt", Algo.pathNameGenerator(11));
        Assert.assertEquals("src\\words12.txt", Algo.pathNameGenerator(12));
        Assert.assertEquals("src\\words13.txt", Algo.pathNameGenerator(13));
        Assert.assertEquals("src\\words14.txt", Algo.pathNameGenerator(14));
        Assert.assertEquals("src\\words15.txt", Algo.pathNameGenerator(15));

    }
    }