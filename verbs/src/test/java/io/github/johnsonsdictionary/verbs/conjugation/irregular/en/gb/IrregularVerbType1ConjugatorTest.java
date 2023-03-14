package io.github.johnsonsdictionary.verbs.conjugation.irregular.en.gb;

import org.junit.jupiter.api.Test;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.base.IrregularVerbConjugatorTestBase;

public class IrregularVerbType1ConjugatorTest extends IrregularVerbConjugatorTestBase {

    @Test
    public void testIrregularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_IRREGULAR_VERBS_TYPE_1, EXPECTED_CONJUGATED_VERBS_TYPE_1_FILE_PATH);
    }

}
