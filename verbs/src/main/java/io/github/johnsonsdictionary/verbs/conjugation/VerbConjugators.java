package io.github.johnsonsdictionary.verbs.conjugation;

import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.IrregularMultiWordVerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.IrregularVerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.regular.RegularMultiWordVerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.regular.RegularVerbConjugator;

import java.util.Arrays;

public class VerbConjugators {

    private final static String IRREGULAR_VERBS_TYPE_1_CONJUGATIONS_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_1_conjugations.csv";
    private final static String IRREGULAR_VERBS_TYPE_2_CONJUGATIONS_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_2_conjugations.csv";

    public final static IrregularVerbConjugator IRREGULAR_VERB_CONJUGATOR = new IrregularVerbConjugator(Arrays.asList(IRREGULAR_VERBS_TYPE_1_CONJUGATIONS_FILE_PATH, IRREGULAR_VERBS_TYPE_2_CONJUGATIONS_FILE_PATH));

    public final static VerbConjugator<VerbConjugation> IRREGULAR_MULTI_WORD_VERB_CONJUGATOR = new IrregularMultiWordVerbConjugator(EnglishWordsEnGB.MULTI_WORD_CONJUGATED_IRREGULAR_VERBS);

    public final static VerbConjugator<VerbConjugation> REGULAR_MULTI_WORD_VERB_CONJUGATOR = new RegularMultiWordVerbConjugator(EnglishWordsEnGB.MULTI_WORD_CONJUGATED_REGULAR_VERBS);

    public final static RegularVerbConjugator REGULAR_VERB_CONJUGATOR = new RegularVerbConjugator();

}
