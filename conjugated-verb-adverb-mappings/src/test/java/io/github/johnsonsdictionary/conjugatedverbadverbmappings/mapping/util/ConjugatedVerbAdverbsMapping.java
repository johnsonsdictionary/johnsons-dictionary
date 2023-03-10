package io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.util;

import java.util.List;

public class ConjugatedVerbAdverbsMapping {
    private String conjugatedVerb;

    private int verbMeaningId;
    private List<String> adverbs;

    public int getVerbMeaningId() {
        return verbMeaningId;
    }

    public ConjugatedVerbAdverbsMapping(String conjugatedVerb, int adjectiveMeaningId, List<String> adverbs) {
        this.conjugatedVerb = conjugatedVerb;
        this.verbMeaningId = adjectiveMeaningId;
        this.adverbs = adverbs;
    }

    public String getConjugatedVerb() {
        return conjugatedVerb;
    }

    public List<String> getAdverbs() {
        return adverbs;
    }
}
