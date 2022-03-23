import dictionaries.EnglishDictionary;
import org.junit.Assert;
import org.junit.Test;

public class EnglishDictionaryTest {

    private EnglishDictionary dictionary;

    @Test
    public void IsWordOnDictionaryReturnsProperBoolean() {
        dictionary = new EnglishDictionary();
        Assert.assertTrue(dictionary.IsWordOnDictionary("KING"));
        Assert.assertFalse(dictionary.IsWordOnDictionary("afjp"));
    }
}
