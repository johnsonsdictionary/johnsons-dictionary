package io.github.johnsonsdictionary.verbs.conjugation.irregular.en.gb;

import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.base.IrregularVerbConjugatorTestBase;
import org.junit.jupiter.api.Test;

public class IrregularMultiWordVerbConjugatorTest extends IrregularVerbConjugatorTestBase {

    public IrregularMultiWordVerbConjugatorTest() {
        super(VerbConjugators.IRREGULAR_MULTI_WORD_VERB_CONJUGATOR);
    }

    @Test
    public void testIrregularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.ALL_IRREGULAR_MULTI_WORD_VERBS, EXPECTED_CONJUGATED_MULTI_WORD_VERBS_TYPE_1_FILE_PATH);
    }

}
