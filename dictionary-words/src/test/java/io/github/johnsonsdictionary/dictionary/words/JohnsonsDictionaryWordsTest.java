package io.github.johnsonsdictionary.dictionary.words;

import io.github.johnsonsdictionary.dictionary.core.JohnsonsDictionary;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                List<String> remaining = new ArrayList<>();
                remaining.addAll(dictionaryWordsIncludingOmitted);
                remaining.removeAll(allWordsIncludingConjugationsAndDerivedIncludingOmitted);
                System.out.println("Unaccounted for:" + remaining);
                Assertions.fail("All words including conjugations and derived and omissions should include all dictionary words and omissions");
            } else {
                System.out.println("All words including conjugations,derived words and omitted words count:" + allWordsIncludingConjugationsAndDerivedIncludingOmitted.size());
                System.out.println("Dictionary words together with omitted words count:" + dictionaryWordsIncludingOmitted.size());
            }
    }

    @Test
    public void testAllMiscWordsAreInDictionary() {
        List<String> allWords = JohnsonsDictionary.getDictionaryWords(true);
        for (Map.Entry<WordDefinitionId, WordDefinition> entry :EnglishWordsEnGB.MISC_WORDS.entrySet()) {
            if (!allWords.contains(entry.getKey().getWord())) {
                System.out.println("Doesn't contain:" + entry.getKey().getWord());
            }
        }
    }
}
