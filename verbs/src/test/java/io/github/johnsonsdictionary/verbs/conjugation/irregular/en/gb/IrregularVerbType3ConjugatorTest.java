package io.github.johnsonsdictionary.verbs.conjugation.irregular.en.gb;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.IrregularVerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.ToBeVerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.base.IrregularVerbConjugatorTestBase;


import java.util.SortedMap;
import java.util.TreeMap;

public class IrregularVerbType3ConjugatorTest extends IrregularVerbConjugatorTestBase {

    @Test
    public void testIrregularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_IRREGULAR_VERBS_TYPE_3, EXPECTED_CONJUGATED_VERBS_TYPE_3_FILE_PATH);
    }

    @Override
    protected void testVerbConjugation(SortedMap<WordDefinitionId, WordDefinition> verbs, String expectedResultsFilePath) {

        IrregularVerbConjugator irregularVerbConjugator = VerbConjugators.IRREGULAR_VERB_CONJUGATOR;

        SortedMap<WordDefinitionId, ToBeVerbConjugation> expectedConjugatedVerbs = new TreeMap<>();
        expectedConjugatedVerbs.put(WordDefinitionId.create("be", 1), new ToBeVerbConjugation());

        testVerbConjugation(irregularVerbConjugator, expectedConjugatedVerbs, verbs);
    }

    @Override
    protected void assertEqual(VerbConjugation first, VerbConjugation second) {
        Assertions.assertTrue(first instanceof ToBeVerbConjugation);
        Assertions.assertTrue(second instanceof ToBeVerbConjugation);
    }
}
