package io.github.johnsonsdictionary.verbs.conjugation.base;

import io.github.johnsonsdictionary.dictionary.core.JohnsonsDictionary;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import org.junit.jupiter.api.Assertions;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerbConjugatorTestBase<C extends VerbConjugation> {


    private VerbConjugator<C> verbConjugator;

    public VerbConjugatorTestBase(VerbConjugator<C> verbConjugator) {
        this.verbConjugator = verbConjugator;
    }


    protected List<String> getValuesFromVariables(List<String> csvVariables, String key, boolean required) {
        String prefix = key + "=";
        List<String> candidates = csvVariables.stream().filter(v -> v.startsWith(prefix)).collect(Collectors.toList());
        if (required && candidates.isEmpty()) {
            throw new IllegalStateException("No value defined for key:" + key + " within:" + csvVariables);
        } else {
            return candidates.stream().map(v -> v.substring(prefix.length())).collect(Collectors.toList());
        }
    }

    protected SortedMap<WordDefinitionId, C> getConjugatedVerbs(VerbConjugator<C> verbConjugator, SortedMap<WordDefinitionId, WordDefinition> verbDefinitions) {
        SortedMap<WordDefinitionId, C> results = new TreeMap<>();
        for (Map.Entry<WordDefinitionId, WordDefinition> entry : verbDefinitions.entrySet()) {
            results.put(entry.getKey(), verbConjugator.getConjugatedVerb(entry.getValue()));
        }
        return results;
    }

    protected void assertEqual(VerbConjugation first, VerbConjugation second) {
        Assertions.assertEquals(first, second,  "Conjugation does not match for:" + first.getVerb());
    }

    protected void testVerbConjugation(SortedMap<WordDefinitionId, ? extends C> expectedConjugatedVerbs, SortedMap<WordDefinitionId, WordDefinition> verbs) {

        SortedMap<WordDefinitionId, C> conjugatedVerbsStartingWithA = getConjugatedVerbs(verbConjugator, verbs);


        for (Map.Entry<WordDefinitionId, ? extends C> entry : expectedConjugatedVerbs.entrySet()) {
            if (true || JohnsonsDictionary.DICTIONARY.keySet().stream().filter(w -> w.getWordTypeIndicator().isVerb()).anyMatch((w -> w.getWord().equals(entry.getKey().getWord())))) {

                StringBuilder s = new StringBuilder();
                for (String pastTense : entry.getValue().getPastTenses(SubjectType.FIRST_PERSON_SINGULAR)) {
                    s.append("past_tense=" + pastTense);
                }
                s.append(",");
                for (String pastTense : entry.getValue().getPastParticiples()) {
                    s.append("past_participle=" + pastTense);
                    s.append(",");
                }
                for (String pp : entry.getValue().getPresentParticiples()) {
                    s.append("present_participle=" + pp);
                    s.append(",");
                }
                String s1 = s.toString();
                s1 = s1.substring(0, s1.length() - 1);
                System.out.println(entry.getKey().getWord() + "," + s1);
                /*
                WordDefinition wordDefinition = EnglishWordsEnGB.ALL_REGULAR_VERBS.get(entry.getKey());
                if (wordDefinition.getStressOnLastSyllable().isPresent() && wordDefinition.getComponents().size() > 1) {
                   // System.out.println(wordDefinition.getWord() + "," + wordDefinition.getStressOnLastSyllable().get().booleanValue() + "," + wordDefinition.getComponents().toString().replace("[", "").replace("]", "").replace(" ", "") );
                } else if (wordDefinition.getStressOnLastSyllable().isPresent() && wordDefinition.getComponents().size() == 1) {
                    //System.out.println(wordDefinition.getWord() + "," + wordDefinition.getStressOnLastSyllable().get().booleanValue() + "," + wordDefinition.getComponents().toString().replace("[", "").replace("]", "").replace(" ", "") );
                } else {
                   // System.out.println(wordDefinition.getWord());
                }

                 */
                assertEqual(entry.getValue(), conjugatedVerbsStartingWithA.get(entry.getKey()));
            }

            //System.out.println(entry.getKey().getWord() + "," + s);
        }
        for (Map.Entry<WordDefinitionId, C> entry : conjugatedVerbsStartingWithA.entrySet()) {
            if (true || JohnsonsDictionary.DICTIONARY.keySet().stream().filter(w -> w.getWordTypeIndicator().isVerb()).anyMatch((w -> w.getWord().equals(entry.getKey().getWord())))) {
                assertEqual(entry.getValue(), expectedConjugatedVerbs.get(entry.getKey()));
            }
        }

        Assertions.assertEquals(expectedConjugatedVerbs.size(), conjugatedVerbsStartingWithA.size());
    }
}
