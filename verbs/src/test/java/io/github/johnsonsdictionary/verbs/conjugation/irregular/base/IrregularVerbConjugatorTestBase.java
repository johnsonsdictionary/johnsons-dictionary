package io.github.johnsonsdictionary.verbs.conjugation.irregular.base;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.base.VerbConjugatorTestBase;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.IrregularVerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.util.VerbConjugationCSVReader;

import java.util.Arrays;
import java.util.SortedMap;

public class IrregularVerbConjugatorTestBase extends VerbConjugatorTestBase {

    protected final static String EXPECTED_CONJUGATED_VERBS_TYPE_1_FILE_PATH = "/english/irregular/en-GB/irregular_verbs_type_1_expected_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_TYPE_2_FILE_PATH = "/english/irregular/en-GB/irregular_verbs_type_2_expected_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_TYPE_3_FILE_PATH = "/english/irregular/en-GB/irregular_verbs_type_3_expected_conjugations.csv";
    protected void testVerbConjugation(SortedMap<WordDefinitionId, WordDefinition> verbs, String expectedResultsFilePath) {

        SortedMap<WordDefinitionId, IrregularVerbConjugation> expectedConjugatedVerbs = new VerbConjugationCSVReader<>((i, v) ->
                new IrregularVerbConjugation(v.get(0), i.getMeaningId(), getValuesFromVariables(v, "past_tense", false), getValuesFromVariables(v, "past_participle", false), getValuesFromVariables(v, "present_participle", true)),
                false, Arrays.asList(expectedResultsFilePath)).load();

        testVerbConjugation(VerbConjugators.IRREGULAR_VERB_CONJUGATOR, expectedConjugatedVerbs, verbs);
    }
}
