package io.github.johnsonsdictionary.dictionary.words;

import io.github.johnsonsdictionary.adjectiveadverbmappings.AdjectiveAdverbMappings;
import io.github.johnsonsdictionary.adjectivesnotmappedtoadverbs.AdjectivesNotMappedToAdverbs;
import io.github.johnsonsdictionary.adverbsnotmappedfromadjectivesorverbs.AdverbsWithoutAdjectivesOrVerbs;
import io.github.johnsonsdictionary.conjugatedverbadverbmappings.ConjugatedVerbAdverbMappings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
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

}
