package io.github.johnsonsdictionary.dictionary.words;

import io.github.johnsonsdictionary.adjectiveadverbmappings.AdjectiveAdverbMappings;
import io.github.johnsonsdictionary.adjectivesnotmappedtoadverbs.AdjectivesNotMappedToAdverbs;
import io.github.johnsonsdictionary.adverbsnotmappedfromadjectivesorverbs.AdverbsWithoutAdjectivesOrVerbs;
import io.github.johnsonsdictionary.articles.Articles;
import io.github.johnsonsdictionary.conjugatedverbadverbmappings.ConjugatedVerbAdverbMappings;
import io.github.johnsonsdictionary.conjunctions.Conjunctions;
import io.github.johnsonsdictionary.dictionary.core.JohnsonsDictionary;
import io.github.johnsonsdictionary.interjections.Interjections;
import io.github.johnsonsdictionary.nouns.Nouns;
import io.github.johnsonsdictionary.particles.Particles;
import io.github.johnsonsdictionary.prepositions.Prepositions;
import io.github.johnsonsdictionary.pronouns.Pronouns;
import io.github.johnsonsdictionary.pronouns.SuperlativeAdjectives;
import io.github.johnsonsdictionary.unclassifiedwords.UnclassifiedWords;


import java.util.*;
import java.util.stream.Collectors;

public class JohnsonsDictionaryWords {

    public static List<String> getAdverbs() {
        List<String> adverbs = new ArrayList<>();
        adverbs.addAll(AdjectiveAdverbMappings.ALL_ADVERBS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        adverbs.addAll(AdverbsWithoutAdjectivesOrVerbs.ALL_ADVERBS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        adverbs.addAll(ConjugatedVerbAdverbMappings.ALL_ADVERBS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        adverbs = adverbs.stream().distinct().collect(Collectors.toList());
        Collections.sort(adverbs);
        return adverbs;
    }

    public static List<String> getAdjectives() {
        List<String> adjectives = new ArrayList<>();
        adjectives.addAll(AdjectiveAdverbMappings.ALL_ADJECTIVES.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        adjectives.addAll(AdjectivesNotMappedToAdverbs.ALL_ADJECTIVES.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        adjectives = adjectives.stream().distinct().collect(Collectors.toList());
        Collections.sort(adjectives);
        return adjectives;
    }

    public static List<String> getInterjections() {
        List<String> interjections = new ArrayList<>();
        interjections.addAll(Interjections.ALL_INTERJECTIONS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        interjections = interjections.stream().distinct().collect(Collectors.toList());
        Collections.sort(interjections);
        return interjections;
    }

    public static List<String> getNouns() {
        List<String> nouns = new ArrayList<>();
        nouns.addAll(Nouns.ALL_NOUNS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        nouns = nouns.stream().distinct().collect(Collectors.toList());
        Collections.sort(nouns);
        return nouns;
    }

    public static List<String> getPlurals() {
        List<String> plurals = new ArrayList<>();
        plurals.addAll(Nouns.ALL_PLURALS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        plurals = plurals.stream().distinct().collect(Collectors.toList());
        Collections.sort(plurals);
        return plurals;
    }

    public static List<String> getNounsAndPlurals() {
        List<String> nounsAndPlurals = new ArrayList<>();
        nounsAndPlurals.addAll(Nouns.ALL_WORDS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        nounsAndPlurals = nounsAndPlurals.stream().distinct().collect(Collectors.toList());
        Collections.sort(nounsAndPlurals);
        return nounsAndPlurals;
    }

    /*
    public static List<String> getVerbs() {
        List<String> verbs = new ArrayList<>();
        verbs.addAll(EnglishWordsEnGB.JOHNSONS_ALL_VERBS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        verbs.addAll(EnglishWordsEnGB.JOHNSONS_IRREGULAR_VERBS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        verbs = verbs.stream().distinct().collect(Collectors.toList());
        Collections.sort(verbs);
        return verbs;
    }

     */

    public static List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        words.addAll(JohnsonsDictionary.DICTIONARY.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        words = words.stream().distinct().collect(Collectors.toList());
        Collections.sort(words);
        return words;
    }

    public static List<String> getPrepositions() {
        List<String> prepositions = new ArrayList<>();
        prepositions.addAll(Prepositions.ALL_PREPOSITIONS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        prepositions = prepositions.stream().distinct().collect(Collectors.toList());
        Collections.sort(prepositions);
        return prepositions;
    }

    public static List<String> getConjunctions() {
        List<String> prepositions = new ArrayList<>();
        prepositions.addAll(Conjunctions.ALL_CONJUNCTIONS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        prepositions = prepositions.stream().distinct().collect(Collectors.toList());
        Collections.sort(prepositions);
        return prepositions;
    }

    public static List<String> getPronouns() {
        List<String> prepositions = new ArrayList<>();
        prepositions.addAll(Pronouns.ALL_PRONOUNS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        prepositions = prepositions.stream().distinct().collect(Collectors.toList());
        Collections.sort(prepositions);
        return prepositions;
    }

    public static List<String> getArticles() {
        List<String> articles = new ArrayList<>();
        articles.addAll(Articles.ALL_ARTICLES.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        articles = articles.stream().distinct().collect(Collectors.toList());
        Collections.sort(articles);
        return articles;
    }

    public static List<String> getParticles() {
        List<String> particles = new ArrayList<>();
        particles.addAll(Particles.ALL_PARTICLES.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        particles = particles.stream().distinct().collect(Collectors.toList());
        Collections.sort(particles);
        return particles;
    }

    public static List<String> getSuperlativeAdjectives() {
        List<String> particles = new ArrayList<>();
        particles.addAll(SuperlativeAdjectives.ALL_SUPERLATIVE_ADJECTIVES.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        particles = particles.stream().distinct().collect(Collectors.toList());
        Collections.sort(particles);
        return particles;
    }

    public static List<String> getUnclassified() {
        List<String> unclassified = new ArrayList<>();
        unclassified.addAll(UnclassifiedWords.ALL_UNCLASSIFIED_WORDS.keySet().stream().map(w -> w.getWord()).collect(Collectors.toList()));
        unclassified = unclassified.stream().distinct().collect(Collectors.toList());
        Collections.sort(unclassified);
        return unclassified;
    }

    public static List<String> getAllCategorisedWords() {
        List<String> words = new ArrayList<>();
        words.addAll(getAdverbs());
        words.addAll(getAdjectives());
        words.addAll(getSuperlativeAdjectives());
        //words.addAll(getVerbs());
        //words.addAll(getAllJohnsonsIrregularConjugations());
        words.addAll(getInterjections());
        words.addAll(getNounsAndPlurals());
        words.addAll(getPrepositions());
        words.addAll(getConjunctions());
        words.addAll(getPronouns());
        words.addAll(getArticles());
        words.addAll(getParticles());
        words.addAll(getUnclassified());
        words = words.stream().distinct().collect(Collectors.toList());
        return words;

    }

    /*
    public static List<String> getAllJohnsonsIrregularConjugations() {

        List<Tense> tensesRequiringPastParticiples = Arrays.asList(Tense.PRESENT_PERFECT, Tense.PRESENT_CONTINUOUS,
                Tense.PRESENT_CONTINUOUS, Tense.FUTURE_PERFECT, Tense.FUTURE_PERFECT_CONTINUOUS, Tense.FUTURE_CONTINUOUS,
                Tense.PAST_PERFECT, Tense.PAST_PERFECT_CONTINUOUS, Tense.PAST_CONTINUOUS);

        List<Tense> tensesRequiringPresentParticiples = Arrays.asList(Tense.PRESENT_PERFECT_CONTINUOUS, Tense.PRESENT_CONTINUOUS,
                Tense.FUTURE_PERFECT_CONTINUOUS, Tense.FUTURE_CONTINUOUS, Tense.PAST_PERFECT_CONTINUOUS,
                Tense.PAST_CONTINUOUS);


        List<String> verbRelatedWords = new ArrayList<>();
        for (WordDefinition wd : EnglishWordsEnGB.JOHNSONS_IRREGULAR_VERBS.values()) {
            VerbConjugation iRegularVerbConjugation = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(wd);
            verbRelatedWords.add(wd.getWord());
            if (!iRegularVerbConjugation.isModelVerb()) {
                if (tensesRequiringPresentParticiples.stream().anyMatch(w -> iRegularVerbConjugation.getSupportedTenses().contains(w))) {
                    verbRelatedWords.addAll(iRegularVerbConjugation.getPresentParticiples());
                }
                if (tensesRequiringPastParticiples.stream().anyMatch(w -> iRegularVerbConjugation.getSupportedTenses().contains(w))) {
                    verbRelatedWords.addAll(iRegularVerbConjugation.getPastParticiples());
                }
            }
            for (SubjectType subjectType : iRegularVerbConjugation.getSupportedSubjectTypes()) {
                // Skip third person singular for now, as the dictionary doesn't contain these
                // conjugations.
                if (!SubjectType.THIRD_PERSON_SINGULAR.equals(subjectType)) {
                    verbRelatedWords.addAll(iRegularVerbConjugation.getPastTenses(subjectType));
                    verbRelatedWords.add(iRegularVerbConjugation.getPresentTense(subjectType));
                }
            }
        }
        verbRelatedWords = verbRelatedWords.stream().distinct().collect(Collectors.toList());
        return verbRelatedWords;
    }

     */

}
