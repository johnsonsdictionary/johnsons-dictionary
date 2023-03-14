package io.github.johnsonsdictionary.verbs.conjugation.specialcases;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;


public class SpecialCaseVerbConjugations {

    public final static WordDefinition TO_HAVE_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("have", 1));

    public final static WordDefinition TO_BE_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("be", 1));

    public final static WordDefinition WILL_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("will", 1));

    public final static WordDefinition SHOULD_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("should", 1));

    public final static WordDefinition SHALL_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("shall", 1));

    public final static WordDefinition OUGHT_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("ought", 1));

    public final static WordDefinition QUOTH_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("quoth", 1));

    public final static WordDefinition METHINKS_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("methinks", 1));

    public final static WordDefinition MESEEMS_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("meseems", 1));

    public final static WordDefinition CAN_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("can", 1));

    public final static WordDefinition MAY_MODAL_VERB_DEFINTION = EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("may", 1));

    public final static VerbConjugation TO_HAVE_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(TO_HAVE_VERB_DEFINTION);

    public final static VerbConjugation TO_BE_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(TO_BE_VERB_DEFINTION);

    public final static VerbConjugation WILL_MODEL_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(WILL_MODAL_VERB_DEFINTION);

    public final static VerbConjugation SHOULD_MODEL_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(SHOULD_MODAL_VERB_DEFINTION);

    public final static VerbConjugation CAN_MODEL_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(CAN_MODAL_VERB_DEFINTION);

    public final static VerbConjugation MAY_MODEL_VERB_CONJUGATION = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(MAY_MODAL_VERB_DEFINTION);

}
