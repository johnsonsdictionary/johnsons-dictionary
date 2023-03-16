package io.github.johnsonsdictionary.verbs.conjugation.regular.en.gb;

import org.junit.jupiter.api.Test;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.regular.base.RegularVerbConjugatorTestBase;

public class JohnsonsAllVerbsConjugatorTest extends RegularVerbConjugatorTestBase {

    @Test
    public void testRegularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_REGULAR_VERBS, EXPECTED_CONJUGATED_JOHNSONS_ALL_VERBS_FILE_PATH);
    }

}
