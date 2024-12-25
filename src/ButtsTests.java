import org.junit.Assert;
import org.junit.Test;

public class ButtsTests {


    @Test
    public void testButtsFirstWay() {

    }

    @Test
    public void testButtsSecondWay() {

    }

    @Test
    public void testDoesWordExist() {
        Butts b = new Butts();
        Assert.assertTrue(b.doesWordExist("ości"));
        Assert.assertTrue(b.doesWordExist("lenno"));
        Assert.assertTrue(b.doesWordExist("zredukowałyście"));
        Assert.assertTrue(b.doesWordExist("zredukowaliście"));
        Assert.assertTrue(b.doesWordExist("wyedukowaliście"));
        Assert.assertTrue(b.doesWordExist("wyedukowałyście"));

        Assert.assertFalse(b.doesWordExist("abdominoplastik"));
        Assert.assertFalse(b.doesWordExist("aborcjonalistoe"));
    }
}
