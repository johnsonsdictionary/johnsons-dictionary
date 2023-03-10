package io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.util;

import java.util.List;

public class AdjectiveAdverbsMapping {
    private String adjective;

    private int adjectiveMeaningId;
    private List<String> adverbs;

    public int getAdjectiveMeaningId() {
        return adjectiveMeaningId;
    }

    public AdjectiveAdverbsMapping(String adjective, int adjectiveMeaningId, List<String> adverbs) {
        this.adjective = adjective;
        this.adjectiveMeaningId = adjectiveMeaningId;
        this.adverbs = adverbs;
    }

    public String getAdjective() {
        return adjective;
    }

    public List<String> getAdverbs() {
        return adverbs;
    }
}
