import org.junit.Assert;

import static org.junit.Assert.*;
public class DictionaryVetTest {

    @org.junit.Test
    public void wordMatchesPattern() {
        Assert.assertTrue(DictionaryVet.wordMatchesPattern("nieaaronowej"));
        Assert.assertTrue(DictionaryVet.wordMatchesPattern("aa"));
        Assert.assertTrue(DictionaryVet.wordMatchesPattern("aalborsku"));
        Assert.assertTrue(DictionaryVet.wordMatchesPattern("nieaaronowy"));

        Assert.assertFalse(DictionaryVet.wordMatchesPattern("Ąkłęmu"));
        Assert.assertFalse(DictionaryVet.wordMatchesPattern("Aalto"));
        Assert.assertFalse(DictionaryVet.wordMatchesPattern("Aachen"));
        Assert.assertFalse(DictionaryVet.wordMatchesPattern(""));
    }
}