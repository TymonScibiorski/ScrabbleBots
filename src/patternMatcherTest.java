import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class patternMatcherTest {

    @Test
    public void testDoesStringMatchGivenLetterPattern(){
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("zupa", "_up_", "za", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("patoloigach", "__t_l__ga__", "paooich", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("patoloigach", "__t_l__ga__", "paooich", 1));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("tol", "__t_l__ga__", "o", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("tol", "__t_l__ga__", "", 1));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("cgar", "__t_l__ga__", "cr", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("cgar", "__t_l__ga__", "r", 1));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("cgar", "__t_l__ga__", "c", 1));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("cgar", "__t_l__ga__", "", 2));

        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("amen", "_m___nić", "aen", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("amen", "_m___nić", "aen", 1));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("fasad", "____d", "fasa", 0));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternAndPlayaLetters("win", "___n", "wi", 0));

        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("lizg", "__t_l__ga__", "iz", 0));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("lizg", "__t_l__ga__", "i", 1));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("lizg", "__t_l__ga__", "z", 1));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("lizg", "__t_l__ga__", "", 2));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("ślizg", "__t_l__ga__", "śiz", 0));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("zupa", "_ur_", "za", 0));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("zupa", "jrqwtyi", "zupa", 0));

        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("kocioł", "____o_y_______", "kocił", 0));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("zorz", "____o_y_ł_____", "zrz", 0));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("okociły", "____o_y_______", "okocił", 0));

        Assert.assertFalse(patternMatcher.doesStringMatchPatternAndPlayaLetters("zdanko", "____d__z_______", "anko", 0));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("rozwodzeń", "_______z__d____", "krowońe", 0));
    }

    @Test
    public void testDoesCheckedWordMatchPatternOfDifferentLength(){
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("tol", "__t_l__ga__", "ooo", 5));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("cgar", "__t_l__ga__", "cr", 0));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("win", "___n", "wiabcn", 5));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("amen", "_m___nić", "zzz", 3));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("lizg", "__t_l__ga__", "iz", 5));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("ślizg", "__t_l__ga__", "śiz", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("zupa", "jrqwtyi", "zupa", 0));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("kocioł", "____o_y_______", "kocił", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("zorz", "____o_y_ł_____",  "zrz", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("okociły", "____o_y_______", "kciły", 0));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("zdanko", "____d__z_______", "anko", 0));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfDifferentLength("rozwodzeń", "_______z__d____", "krowońe", 0));
    }

    @Test
    public void testDoesCheckedWordMatchPatternOfSameLengthAndPlayaLetters(){
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("zupa", "_up_", "apuz", 0));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("patoloigach", "__t_l__ga__", "patoloigach", 0));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("tol", "t_l", "lot", 0));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("tol", "t_l", "lot", 1));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("tol", "t_l", "lt", 1));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("tol", "t_l", "ltjasdf", 1));
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("cgar", "_ga_", "cr", 0));


        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("win", "_d_", "win", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("zupa", "_ud_", "zupa", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("fasad", "__d__", "fasad", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("fasad", "__d__", "farad", 0));
        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("fasad", "__d__", "faad", 0));

        Assert.assertFalse(patternMatcher.doesCheckedWordMatchPatternOfSameLengthAndPlayaLetters("zdanko", "z____d", "anko", 0));
    }

    @Test
    public void testStringWordMatchPatternOfSameLength(){
        Assert.assertTrue(patternMatcher.doesStringMatchPatternOfSameLength("zupa", "_up_"));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternOfSameLength("patoloigach", "__t_l__ga__"));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternOfSameLength("tol", "t_l"));
        Assert.assertTrue(patternMatcher.doesStringMatchPatternOfSameLength("cgar", "_ga_"));

        Assert.assertFalse(patternMatcher.doesStringMatchPatternOfSameLength("win", "_d_"));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternOfSameLength("zupa", "_ud_"));
        Assert.assertFalse(patternMatcher.doesStringMatchPatternOfSameLength("fasad", "__d__"));
    }

    @Test
    public void testAcceptableFragmentsOfPattern(){
        //The words must be shorter than the patterns, because if they weren't, they wouldn't end up in the function in the first place

        ArrayList<String> expected1 = new ArrayList<>();
        expected1.add("abc");
        Assert.assertEquals(expected1, patternMatcher.FragmentsOfPattern("aaa", "abc_"));

        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("abc");
        expected2.add("def");
        expected2.add("ghi");
        Assert.assertEquals(expected2, patternMatcher.FragmentsOfPattern("aaa", "abc_def_ghi"));

        ArrayList<String> expected3 = new ArrayList<>();
        expected3.add("__t");
        expected3.add("t_l");
        expected3.add("_ga");
        expected3.add("ga_");
        Assert.assertEquals(expected3, patternMatcher.FragmentsOfPattern("tol", "__t_l__ga__"));

        ArrayList<String> expected4 = new ArrayList<>();
        expected4.add("__t_l__ga_");
        expected4.add("_t_l__ga__");
        Assert.assertEquals(expected4, patternMatcher.FragmentsOfPattern("patoloigac", "__t_l__ga__"));

        Assert.assertEquals(new ArrayList<>(), patternMatcher.FragmentsOfPattern("cgar", "______________"));


    }


    @Test
    public void testIsFoundPatternJustUnderscores(){
        Assert.assertTrue(patternMatcher.isJustUnderscores("__"));
        Assert.assertTrue(patternMatcher.isJustUnderscores("____"));
        Assert.assertTrue(patternMatcher.isJustUnderscores("_"));
        Assert.assertTrue(patternMatcher.isJustUnderscores("_______"));

        Assert.assertFalse(patternMatcher.isJustUnderscores("_d"));
        Assert.assertFalse(patternMatcher.isJustUnderscores("asodifj"));
        Assert.assertFalse(patternMatcher.isJustUnderscores("as__fj"));
    }

    @Test
    public void testExtractLettersFromPattern(){
        Assert.assertEquals("abcd", patternMatcher.extractLettersFromPattern("abcd"));
        Assert.assertEquals("abcd", patternMatcher.extractLettersFromPattern("a_b_c_d"));
        Assert.assertEquals("abcd", patternMatcher.extractLettersFromPattern("__a_bc_d__"));
        Assert.assertEquals("abcd", patternMatcher.extractLettersFromPattern("__________a_bc_d_"));
    }
}