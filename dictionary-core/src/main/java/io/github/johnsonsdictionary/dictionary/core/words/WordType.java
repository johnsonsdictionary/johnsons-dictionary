package io.github.johnsonsdictionary.dictionary.core.words;

public enum WordType {
    UNDEFINED(false), ADJECTIVE(false), ADVERB(false), PARTICLE(false), CONJUNCTION(false), INTERJECTION(false), NOUN_SUBSTANTIVE(false), PREPOSITION(false),
    PRONOUN(false), VERB_ACTIVE(true), VERB_NEUTER(true), VERB_IMP(true), VERB_IMPERSONAL(true), VERB_AUXILIARY(true), VERB_DEF(true), NA(false), PRETERITE(false), PERF(false), PERS(false), SUBST(false), REC(false), ARTICLE(false), SUPERLATIVE_ADJECTIVE(false),
    PASS(false), SUB(false), POSS(false), PART(false), PL(false);
    private boolean verb;

    WordType(boolean isVerb) {
        this.verb = isVerb;
    }

    public boolean isVerb() {
        return verb;
    }
}
