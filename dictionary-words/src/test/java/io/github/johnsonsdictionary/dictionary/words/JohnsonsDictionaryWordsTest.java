package io.github.johnsonsdictionary.dictionary.words;

import io.github.johnsonsdictionary.dictionary.core.JohnsonsDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JohnsonsDictionaryWordsTest {

    @Test
    public void testDictionaryLoad() {
        Assertions.assertEquals(2610, JohnsonsDictionaryWords.getAdverbs().size());
    }

    @Test
    public void testAllWordsIncludingConjugationsAndDerivedWordsIncludeAllDictionaryWords() {
            List<String> dictionaryWordsIncludingOmitted = JohnsonsDictionary.getDictionaryWords(true);
            List<String> allWordsIncludingConjugationsAndDerivedIncludingOmitted = JohnsonsDictionaryWords.getAllCategorisedAndDerivedWords();
            if (!allWordsIncludingConjugationsAndDerivedIncludingOmitted.containsAll(dictionaryWordsIncludingOmitted)) {
                Assertions.fail("All words including conjugations and derived and omissions should include all dictionary words and omissions");
            } else {
                System.out.println("All words including conjugations,derived words and omitted words count:" + allWordsIncludingConjugationsAndDerivedIncludingOmitted.size());
                System.out.println("Dictionary words together with omitted words count:" + dictionaryWordsIncludingOmitted.size());
            }
    }
}
