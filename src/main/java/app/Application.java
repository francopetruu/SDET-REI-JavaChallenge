package app;

import dictionaries.EnglishDictionary;
import interfaces.IDictionaryAPI;

import java.util.List;

import static utils.StringPermutation.FindWordPermutations;

public class Application {

    public static void main(String[] args) {
        String word = "GOL";
        IDictionaryAPI dictionary = new EnglishDictionary();
        List<String> permutations = FindWordPermutations(word);
        int count = 0;
        System.out.println(permutations);
        System.out.println("English words in: " + word);
        for (String permutation : permutations) {
            if (dictionary.IsWordOnDictionary(permutation)) {
                System.out.println(permutation);
                count ++;
            }
        }
        System.out.println("Total English words number: " + count);
    }
}
