package io.github.johnsonsdictionary.verbs.conjugation.regular.en.gb;

import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.regular.base.RegularVerbConjugatorTestBase;
import org.junit.jupiter.api.Test;

public class JohnsonsMultiWordRegularVerbsConjugatorTest extends RegularVerbConjugatorTestBase {

    public JohnsonsMultiWordRegularVerbsConjugatorTest() {
        super(VerbConjugators.REGULAR_MULTI_WORD_VERB_CONJUGATOR);
    }

    @Test
    public void testRegularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_REGULAR_MULTI_WORD_VERBS, EXPECTED_CONJUGATED_JOHNSONS_ALL_MULTI_WORD_VERBS_FILE_PATH);
    }

}
