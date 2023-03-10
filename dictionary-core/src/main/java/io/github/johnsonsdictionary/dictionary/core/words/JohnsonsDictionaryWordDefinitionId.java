package io.github.johnsonsdictionary.dictionary.core.words;

import java.util.Objects;

public class JohnsonsDictionaryWordDefinitionId implements Comparable<JohnsonsDictionaryWordDefinitionId> {

    private String word;
    private int meaningId;

    private WordTypeIndicator wordTypeIndicator;

    public WordTypeIndicator getWordTypeIndicator() {
        return wordTypeIndicator;
    }

    public String getWord() {
        return word;
    }

    public int getMeaningId() {
        return meaningId;
    }

    public static JohnsonsDictionaryWordDefinitionId create(String word, WordTypeIndicator wordTypeIndicator, int meaningId) {
        return new JohnsonsDictionaryWordDefinitionId(word, wordTypeIndicator, meaningId);
    }

    public JohnsonsDictionaryWordDefinitionId(String word, WordTypeIndicator wordTypeIndicator, int meaningId) {
        this.word = word;
        this.meaningId = meaningId;
        this.wordTypeIndicator = wordTypeIndicator;
        if (meaningId < 1) {
            throw new IllegalArgumentException("Meaning id must be 1 or greater");
        }
    }

    @Override
    public String toString() {
        return "JDWordDefinitionId{" +
                "word='" + word + '\'' +
                ", meaningId=" + meaningId +
                ", wordTypeIndicator=" + wordTypeIndicator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JohnsonsDictionaryWordDefinitionId that = (JohnsonsDictionaryWordDefinitionId) o;
        return meaningId == that.meaningId && Objects.equals(word, that.word) && wordTypeIndicator == that.wordTypeIndicator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, meaningId, wordTypeIndicator);
    }

    @Override
    public int compareTo(JohnsonsDictionaryWordDefinitionId o) {
        int wordComparison = this.getWord().compareTo(o.getWord());
        if (wordComparison != 0) {
            return wordComparison;
        } else {
            int comp =  wordTypeIndicator.compareTo(o.getWordTypeIndicator());
            if (comp == 0) {
                return Integer.valueOf(this.meaningId).compareTo(o.getMeaningId());
            } else {
                return comp;
            }
        }
    }
}
