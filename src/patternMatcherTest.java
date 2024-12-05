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

//        Assert.assertFalse(patternMatcher.doesStringMatchGivenLetterPattern("zdanko", "____d__z_______"));
//        Assert.assertTrue(patternMatcher.doesStringMatchGivenLetterPattern("amen", "_m___nić"));
//        Assert.assertTrue(patternMatcher.doesStringMatchGivenLetterPattern("fasad", "____d"));
        Assert.assertTrue(patternMatcher.doesStringMatchPattern("win", "___n"));
    }


    @Test
    public void testAcceptableFragmentsOfPattern(){
        ArrayList<String> expected1 = new ArrayList<>();
        expected1.add("abc");
        Assert.assertEquals(expected1, patternMatcher.AcceptableFragmentsOfPattern("aaa", "abc_"));

        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("abc");
        expected2.add("def");
        expected2.add("ghi");
        Assert.assertEquals(expected2, patternMatcher.AcceptableFragmentsOfPattern("aaa", "abc_def_ghi"));
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
}