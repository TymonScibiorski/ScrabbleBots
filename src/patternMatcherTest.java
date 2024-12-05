import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class patternMatcherTest {

    @Test
    public void testDoesStringMatchGivenLetterPattern(){
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("zupa", "_up_"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("patoloigach", "__t_l__ga__"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("tol", "__t_l__ga__"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("cgar", "__t_l__ga__"));

        Assert.assertFalse(patternMatcher.doesStringMatchPattern("lizg", "__t_l__ga__"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("ślizg", "__t_l__ga__"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("zupa", "_ur_"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("zupa", "jrqwtyi"));

        Assert.assertFalse(patternMatcher.doesStringMatchPattern("kocioł", "____o_y_______"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("zorz", "____o_y_ł_____"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("okociły", "____o_y_______"));

//        Assert.assertFalse(patternMatcher.doesStringMatchPattern("zdanko", "____d__z_______"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("amen", "_m___nić"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("fasad", "____d"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("win", "___n"));
    }


    @Test
    public void testAcceptableFragmentsOfPattern(){
        //The words must be shorter than the patterns, because if they weren't, they wouldn't end up in the function in the first place

        ArrayList<String> expected1 = new ArrayList<>();
        expected1.add("abc");
        Assert.assertEquals(expected1, patternMatcher.AcceptableFragmentsOfPattern("aaa", "abc_"));

        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("abc");
        expected2.add("def");
        expected2.add("ghi");
        Assert.assertEquals(expected2, patternMatcher.AcceptableFragmentsOfPattern("aaa", "abc_def_ghi"));

        ArrayList<String> expected3 = new ArrayList<>();
        expected3.add("__t");
        expected3.add("t_l");
        expected3.add("_ga");
        expected3.add("ga_");
        Assert.assertEquals(expected3, patternMatcher.AcceptableFragmentsOfPattern("tol", "__t_l__ga__"));

        ArrayList<String> expected4 = new ArrayList<>();
        expected4.add("__t_l__ga_");
        expected4.add("_t_l__ga__");
        Assert.assertEquals(expected4, patternMatcher.AcceptableFragmentsOfPattern("patoloigac", "__t_l__ga__"));

        Assert.assertEquals(new ArrayList<>(), patternMatcher.AcceptableFragmentsOfPattern("cgar", "______________"));


    }

    @Test
    public void testDoesCheckedWordMatchPatternOfSameLength(){
        Assert.assertTrue(patternMatcher.doesCheckedWordMatchPatternOfSameLength("zupa", "_up_"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("patoloigach", "__t_l__ga__"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("tol", "t_l"));

        Assert.assertFalse(patternMatcher.doesStringMatchPattern("win", "_d_"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("zupa", "_ud_"));
        Assert.assertFalse(patternMatcher.doesStringMatchPattern("fasad", "__d__"));
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