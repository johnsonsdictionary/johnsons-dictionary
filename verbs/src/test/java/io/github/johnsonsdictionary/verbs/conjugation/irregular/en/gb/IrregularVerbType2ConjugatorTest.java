package io.github.johnsonsdictionary.verbs.conjugation.irregular.en.gb;

import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import org.junit.jupiter.api.Test;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.base.IrregularVerbConjugatorTestBase;

public class IrregularVerbType2ConjugatorTest extends IrregularVerbConjugatorTestBase {

    public IrregularVerbType2ConjugatorTest() {
        super(VerbConjugators.IRREGULAR_VERB_CONJUGATOR);
    }

    @Test
    public void testIrregularVerbConjugation() {
        testVerbConjugation(EnglishWordsEnGB.JOHNSONS_IRREGULAR_VERBS_TYPE_2, EXPECTED_CONJUGATED_VERBS_TYPE_2_FILE_PATH);
    }

}
