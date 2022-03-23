import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.StringPermutation.FindWordPermutations;

public class StringPermutationTest {
    @Test
    /**
     * p = (n! / (n-(n-1))) + n! Permutation allowing subsets formula
     * n = 3 p = 12
     *
     * */
    public void IsFindWordCombinationsReturningRightLengthArray() {
        List<String> combinations = FindWordPermutations("ABC");
        Assert.assertTrue("The actual size was: " + combinations.size(), combinations.size() <= 12 );
    }

    @Test
    public void IsOriginalWordContainedOnResultPermutationArray() {
        String originalStr = "KING";
        List<String> combinations = FindWordPermutations(originalStr);
        Assert.assertTrue("Actual results list: " + combinations, combinations.contains(originalStr));
    }

    @Test
    public void IsFindWordCombinationsReturningDuplicates() {
        boolean flag = false;
        Set<String> noDuplicates = new HashSet<String>();
        List<String> combinations = FindWordPermutations("KING");
        System.out.println("Results list length: " + combinations.size());
        for(String string : combinations) {
            if(!noDuplicates.add(string)) {
                flag = true;
            }
        }
        System.out.println("Results hashset length: " + noDuplicates.size());
        Assert.assertFalse(flag);
    }
}
