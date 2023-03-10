package io.github.johnsonsdictionary.dictionary.core.words;

import java.util.Arrays;
import java.util.List;

public enum WordTypeIndicator {

    UNDEFINED(Arrays.asList(""), Arrays.asList(WordType.UNDEFINED)),
    ADJECTIVE(Arrays.asList("ad.", "adj.", "adj"), Arrays.asList(WordType.ADJECTIVE)),
    ADVERB(Arrays.asList("adv.", "adv"), Arrays.asList(WordType.ADVERB)),
    CONJUNCTION(Arrays.asList("conj."), Arrays.asList(WordType.CONJUNCTION)),
    INTERJECTION(Arrays.asList("interj", "interject.", "interj."), Arrays.asList(WordType.INTERJECTION)),
    NOUN_SUBSTANTIVE(Arrays.asList("n.s.", "n.s", "ns", "ns."), Arrays.asList(WordType.NOUN_SUBSTANTIVE)),
    PREPOSITION(Arrays.asList("prep", "preposit.", "prep."), Arrays.asList(WordType.PREPOSITION)),
    PRONOUN(Arrays.asList("pron."), Arrays.asList(WordType.PRONOUN)),
    VERB_ACTIVE(Arrays.asList("v.a.", "v.a"), Arrays.asList(WordType.VERB_ACTIVE)),
    VERB_NEUTER(Arrays.asList("v.n.", "v. n", "v. n."), Arrays.asList(WordType.VERB_NEUTER)),
    PARTICLE(Arrays.asList("particle", "particle."), Arrays.asList(WordType.PARTICLE)),
    PART(Arrays.asList("part."), Arrays.asList(WordType.PART)),
    PRET(Arrays.asList("pret."), Arrays.asList(WordType.PRETERITE)),
    NA(Arrays.asList("n.a."), Arrays.asList(WordType.NA)),
    ARTICLE(Arrays.asList("article."), Arrays.asList(WordType.ARTICLE)),
    SUPERL(Arrays.asList("superl."), Arrays.asList(WordType.SUPERLATIVE_ADJECTIVE)),
    PART_ADJ(Arrays.asList("part. adj."), Arrays.asList(WordType.PART, WordType.ADJECTIVE)),
    PART_PASS(Arrays.asList("part. pass.", "part. pass"), Arrays.asList(WordType.PART, WordType.PASS)),
    ADV_OR_PREP(Arrays.asList("adv. or prep."), Arrays.asList(WordType.ADVERB, WordType.PREPOSITION)),
    VN_PASS(Arrays.asList("v.n. pass."), Arrays.asList(WordType.VERB_NEUTER, WordType.PASS)),
    PART_PRET(Arrays.asList("part. pret.", "pret. and part."), Arrays.asList(WordType.PART, WordType.PRETERITE)),
    PRET_AND_PART_PASS(Arrays.asList("pret. and part. pass.", "pret. and part. pass"), Arrays.asList(WordType.PRETERITE, WordType.PART, WordType.PASS)),
    NS_PL(Arrays.asList("n.s. pl."), Arrays.asList(WordType.NOUN_SUBSTANTIVE, WordType.PL)),
    PL(Arrays.asList("pl."), Arrays.asList(WordType.PL)),
    VA_AND_VN(Arrays.asList("v.a. and v.n."), Arrays.asList(WordType.VERB_ACTIVE, WordType.VERB_NEUTER)),
    PART_SUB(Arrays.asList("part. sub."), Arrays.asList(WordType.PART, WordType.SUB)),
    ADJ_SUPERL(Arrays.asList("adj. superl."), Arrays.asList(WordType.SUPERLATIVE_ADJECTIVE)),
    PART_AND_PRET(Arrays.asList("part. and pret."), Arrays.asList(WordType.PART, WordType.PRETERITE)),
    ADV_OR_INTERJ(Arrays.asList("adv. or interj."), Arrays.asList(WordType.ADVERB, WordType.INTERJECTION)),
    PRET_PASS(Arrays.asList("pret. pass."), Arrays.asList(WordType.PASS, WordType.PRETERITE)),
    V_IMP(Arrays.asList("v. imp."), Arrays.asList(WordType.VERB_IMP)),
    PRON_POSS(Arrays.asList("pron. poss."), Arrays.asList(WordType.PRONOUN, WordType.POSS)),
    IMPERSONAL_VERB(Arrays.asList("impersonal verb", "impersonal verb."), Arrays.asList(WordType.VERB_IMPERSONAL)),
    AUXILIARY_VERB(Arrays.asList("auxiliary verb", "auxiliary verb,"), Arrays.asList(WordType.VERB_AUXILIARY)),
    PRON_REC(Arrays.asList("pron. rec."), Arrays.asList(WordType.PRONOUN, WordType.REC)),
    ADJ_OR_PART(Arrays.asList("adj. or part."), Arrays.asList(WordType.ADJECTIVE, WordType.PART)),
    SUBST_OR_ADV(Arrays.asList("subst. or adv."), Arrays.asList(WordType.SUBST, WordType.ADVERB)),
    SUBST(Arrays.asList("subst."), Arrays.asList(WordType.SUBST)),
    PRON_PERS(Arrays.asList("pron. pers."), Arrays.asList(WordType.PRONOUN, WordType.PERS)),
    PASS(Arrays.asList("pass,", "pass."), Arrays.asList(WordType.PASS)),
    NS_AND_INTERJ(Arrays.asList("n.s. and interj."), Arrays.asList(WordType.NOUN_SUBSTANTIVE, WordType.INTERJECTION)),
    PERF_AND_PART_PASS(Arrays.asList("perf. and part. pass."), Arrays.asList(WordType.PERF, WordType.PART, WordType.PASS)),
    V_DEFECTIVE(Arrays.asList("v. def."), Arrays.asList(WordType.VERB_DEF)),
    ADJ_AND_ADV(Arrays.asList("adj. and adv."), Arrays.asList(WordType.ADJECTIVE, WordType.ADVERB)),
    ADJ_OR_NS(Arrays.asList("adj. or n.s."), Arrays.asList(WordType.ADJECTIVE, WordType.NOUN_SUBSTANTIVE)),
    PART_PASSIVE(Arrays.asList("(part. passive)"), Arrays.asList(WordType.PART, WordType.PASS));
    List<String> indicators;
    List<WordType> wordTypes;

    public List<WordType> getWordTypes() {
        return wordTypes;
    }

    WordTypeIndicator(List<String> indicators, List<WordType> wordTypes) {
        this.indicators = indicators;
        this.wordTypes = wordTypes;
    }

    public List<String> getIndicators() {
        return indicators;
    }

    public boolean isOfType(WordType wordType) {
        return wordTypes.contains(wordType);
    }

    public boolean isVerb() {
        return wordTypes.stream().anyMatch(w -> w.isVerb());
    }

    public static WordTypeIndicator create(String indicator) {
        if (indicator.trim().length() == 0) {
            return WordTypeIndicator.UNDEFINED;
        } else {
            for (WordTypeIndicator wordType : values()) {
                if (wordType.getIndicators().contains(indicator)) {
                    return wordType;
                }
            }
            throw new IllegalArgumentException("Unknown indicator:" + indicator);
        }
    }
}
