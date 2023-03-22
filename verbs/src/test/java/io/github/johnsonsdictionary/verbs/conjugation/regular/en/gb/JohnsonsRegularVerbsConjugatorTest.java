package io.github.johnsonsdictionary.verbs.conjugation.regular.en.gb;

import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import org.junit.jupiter.api.Test;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.regular.base.RegularVerbConjugatorTestBase;

public class JohnsonsRegularVerbsConjugatorTest extends RegularVerbConjugatorTestBase {

    public JohnsonsRegularVerbsConjugatorTest() {
        super(VerbConjugators.REGULAR_VERB_CONJUGATOR);
    }

    @Test
    public void testRegularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_REGULAR_VERBS, EXPECTED_CONJUGATED_JOHNSONS_ALL_VERBS_FILE_PATH);
    }

}
