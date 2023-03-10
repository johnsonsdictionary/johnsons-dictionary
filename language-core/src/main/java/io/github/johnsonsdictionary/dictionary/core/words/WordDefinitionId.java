package io.github.johnsonsdictionary.dictionary.core.words;

import java.util.Objects;

public class WordDefinitionId implements Comparable<WordDefinitionId> {

    private String word;
    private int meaningId;

    public String getWord() {
        return word;
    }

    public int getMeaningId() {
        return meaningId;
    }

    public static WordDefinitionId create(String word, int meaningId) {
        return new WordDefinitionId(word, meaningId);
    }

    public WordDefinitionId(String word, int meaningId) {
        this.word = word;
        this.meaningId = meaningId;
        if (meaningId < 1) {
            throw new IllegalArgumentException("Meaning id must be 1 or greater");
        }
    }

    @Override
    public String toString() {
        return "WordDefinitionId{" +
                "word='" + word + '\'' +
                ", meaningId=" + meaningId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordDefinitionId that = (WordDefinitionId) o;
        return meaningId == that.meaningId &&
                Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, meaningId);
    }

    @Override
    public int compareTo(WordDefinitionId o) {
        int wordComparison = this.getWord().compareTo(o.getWord());
        if (wordComparison != 0) {
            return wordComparison;
        } else {
            return Integer.valueOf(this.meaningId).compareTo(o.getMeaningId());
        }
    }
}
