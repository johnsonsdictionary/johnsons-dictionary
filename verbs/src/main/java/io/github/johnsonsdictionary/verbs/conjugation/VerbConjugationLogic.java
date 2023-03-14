
package io.github.johnsonsdictionary.verbs.conjugation;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Initial prototype functionality for conjugating English verbs ( British English).
 * <p>
 * Messy code in here - to be tidied up and moved into RegularVerbConjugator.
 * <p>
 * Lots of logic branches - some with inclusions for suffices - could be negated to use exclusions instead.
 * <p>
 * I plan on re-working this logic with the aim of obtaining the simplest logic to conjugate regular verbs.
 * <p>
 * Tested on the entire alphabet of a dataset of verbs I have locally ( not an exhaustive list by any means),
 * but so far I've only committed the set of verbs starting "a" - with more to add over time.
 *
 * @author Michael Lavelle
 */
public class VerbConjugationLogic {

    private final static List<String> TEMPORARY_EXCLUSIONS = Arrays.asList("cache", "saute", "flambe", "coif", "pretzel");

    public final static List<String> stressDependentWords = new ArrayList<>();

    private final static String O = "o";
    private final static String A = "a";
    private final static String M = "m";
    private final static String F = "f";

    private final static String I = "i";
    private final static String Y = "y";
    private final static String C = "c";
    private final static String K = "k";
    private final static String U = "u";
    private final static String V = "v";

    private final static String T = "t";

    private final static String B = "b";

    private final static String G = "g";

    private final static String R = "r";
    private final static String E = "e";
    private final static String D = "d";


    private final static String ING = "ing";
    private final static String YING = Y + ING;


    private final static String EE = "ee";
    private final static String IE = "ie";

    private final static String IC = I + C;
    private final static String AC = A + C;

    private final static String ET = "et";
    private final static String EL = "el";
    private final static String ED = "ed";

    private final static String UT = "ut";
    private final static String UP = "up";
    private final static String AP = "ap";
    private final static String AT = "at";

    private final static String AL = "al";
    private final static String IL = "il";
    private final static String IT = "it";

    private final static String S = "s";

    private final static String H = "h";

    private final static String Z = "z";

    private final static String ZZ = Z + Z;

    private final static String IZ = I + Z;


    private final static String GO = G + O;

    private final static String HO = H + O;

    private final static String DO = D + O;


    private final static String CH = C + H;

    private final static String TH = T + H;

    private final static String SH = S + H;

    private final static String AY = A + Y;

    private final static String EY = E + Y;

    private final static String UY = U + Y;

    private final static String OY = O + Y;

    private final static String OO = O + O;

    private final static String ES = E + S;

    private final static String US = U + S;

    private final static String IES = I + ES;


    private final static String X = "x";


    private final static String MIE = M + IE;

    private final static String UAT = U + AT;

    private final static String BAT = B + AT;

    private final static String MAT = M + AT;

    private final static String MIT = M + IT;

    private final static String FIT = F + IT;

    private final static String UIP = "uip";

    private final static String UIZ = "uiz";

    private final static String VIL = V + IL;

    private final static String FIL = F + IL;

    private final static String CIL = C + IL;

    private final static String RIL = R + IL;

    private final static String IED = I + ED;

    private final static String EEL = E + EL;

    private final static String EAP = E + AP;

    private final static String SES = S + ES;

    private final static String ZES = Z + ES;

    private final static String ATH = A + TH;

    private final static String HAVE = H + A + V + E;

    private final static String SOOTH = S + OO + TH;


    /**
     * The Past tense for regular verbs (so far) can be derived using a sequence of rules.
     * <p>
     * This method can only be applied to regular verbs
     *
     * @param allWords All words in the dictionary ( regular verbs, irregular verbs, and miscellaneous words)
     * @param verb     The verb to obtain the past tense for.
     * @return The past tense
     */
    public static String getPastTenseForRegularVerb(Map<WordDefinitionId, WordDefinition> allWords, WordDefinition verb) {
        if (EnglishWordsEnGB.ALL_REGULAR_VERBS.containsKey(verb.getWordDefinitionId())) {
            String doubleCandidate = addEndingForPastTense(verb.getWord() + verb.getWord().substring(verb.getWord().length() - 1));
            String notDoubleCandidate = addEndingForPastTense(verb.getWord());
            String addKForICOrACOrKEnding = addEndingForPastTense(verb.getWord() + K);
            return getConjugation(allWords, verb, doubleCandidate, notDoubleCandidate, addKForICOrACOrKEnding);
        } else {
            throw new IllegalArgumentException("Verb is not regular:" + verb);
        }
    }

    /**
     * The Present Participle tense any verb, regular or irregular (so far, and excluding "to be") can be derived using a sequence of rules.
     * <p>
     * This method can be applied to both regular or irregular verbs ( excluding "to be")
     *
     * @param allWords All words in the dictionary ( regular verbs, irregular verbs, and miscellaneous words)
     * @param verb     The verb to obtain the past tense for.
     * @return The present participle
     */
    public static String getPresentParticiple(Map<WordDefinitionId, WordDefinition> allWords, WordDefinition verb) {
        String doubleCandidate = addEndingForPresentParticiple(verb.getWord() + verb.getWord().substring(verb.getWord().length() - 1));
        String notDoubleCandidate = addEndingForPresentParticiple(verb.getWord());
        String addKForICOrACOrKEnding = addEndingForPresentParticiple(verb.getWord() + K);
        return getConjugation(allWords, verb, doubleCandidate, notDoubleCandidate, addKForICOrACOrKEnding);
    }


    private static boolean isComposite(WordDefinition verb) {
        return verb.getComponents().size() > 1;
    }

    private static boolean isStressOnLastSyllable(WordDefinition verb) {
        if (!stressDependentWords.contains(verb.getWord())) {
            stressDependentWords.add(verb.getWord());
        }
        return verb.isStressOnLastSyllable();
    }

    private static String getCompositePrefix(WordDefinition verb) {
        return verb.getComponents().get(0);
    }

    private static WordDefinition getWordDefinition(Map<WordDefinitionId, WordDefinition> wordDefinitions, String word) {
        /// TODO make more efficient
        List<WordDefinition> matching = wordDefinitions.values().stream().filter(w -> w.getWord().equals(word)).collect(Collectors.toList());
        if (matching.size() != 1) {
            if (matching.size() > 1) {
                // TEMP
                WordDefinition first = matching.get(0);
                for (int i = 1; i < matching.size(); i++) {
                    WordDefinition other = matching.get(1);
                    if (!first.getWord().equals(other.getWord()) || !first.getComponents().equals(other.getComponents()) || !first.getStressOnLastSyllable().equals(other.getStressOnLastSyllable())) {
                        throw new IllegalStateException("Multiple definition for:" + word + " that are different");
                    }
                }
                return matching.get(0);
            } else {
                throw new IllegalStateException("Not found: definition for:" + word);
            }
        } else {
            return matching.get(0);
        }
    }

    private static String getConjugation(Map<WordDefinitionId, WordDefinition> allWords, WordDefinition wordDefinition, String doubleCandidate, String notDoubleCandidate, String addKForICOrACOrKEnding) {
        String verb = wordDefinition.getWord();

        if (verb.length() < 2) {
            //throw new IllegalStateException("Verbs must be at least two letters");
        }
        if (isComposite(wordDefinition)) {
            String prefix = getCompositePrefix(wordDefinition);
            if (verb.startsWith(prefix)) {
                String suffixStringIncludingDelimiter = verb.substring(prefix.length());
                String secondWordComponent = wordDefinition.getComponents().get(1);
                int secondWordComponentIndex = suffixStringIncludingDelimiter.indexOf(secondWordComponent);
                if (secondWordComponentIndex == -1) {
                    throw new RuntimeException("Issue with config for verb:" + verb);
                }
                String suffixString = suffixStringIncludingDelimiter.substring(secondWordComponentIndex);

                String delimiter = suffixStringIncludingDelimiter.substring(0, secondWordComponentIndex);

                WordDefinition suffix = getWordDefinition(allWords, suffixString);
                return prefix + delimiter + getConjugation(allWords, suffix, doubleCandidate.substring(prefix.length() + delimiter.length()), notDoubleCandidate.substring(prefix.length() + delimiter.length()), addKForICOrACOrKEnding.substring(prefix.length() + delimiter.length()));
            } else {
                throw new IllegalStateException("Invalid prefix:" + verb + ":" + prefix);
            }
        }

        if (verb.equals("k")) {
            return notDoubleCandidate;
        }

        String verbLastLetter = verb.substring(verb.length() - 1);
        String verbLastTwoLetters = verb.substring(verb.length() - 2);

        if (verbLastLetter.equals("c")) {
            if (verb.endsWith(IC) || verb.endsWith(AC)) {
                return addKForICOrACOrKEnding;
            } else {
                return notDoubleCandidate;
            }
            // Do we need this separation - or will the double rules apply ?
        } else if (verbLastLetter.equals(K)) {
            // trek, yak, but not kayak
            if (matchesConsonantVowelConsonantEndingRule(verb) && (verb.endsWith("ek") || (verb.endsWith("ak") && !verb.endsWith("ayak")))) {
                return addKForICOrACOrKEnding;
            } else {
                return notDoubleCandidate;
            }
        } else if (verbLastLetter.equals(Y)) {
            return notDoubleCandidate;
        } else if (Arrays.asList("a", "e", "h", "i", "j", K, "o", "q", U, "w", "x", Y).contains(verbLastLetter)) {
            return notDoubleCandidate;
        } else if (verbLastTwoLetters.equals(ET)) {
            if (verb.endsWith("duet")) {
                return doubleCandidate;
            } else {
                return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
            }
        } else if (verbLastTwoLetters.equals(UT)) {
            if (verb.endsWith("input")) {
                return doubleCandidate;
            } else {
                return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
            }
        } else if (verbLastTwoLetters.equals(EL)) {
            if (verb.endsWith(EEL)) {
                return notDoubleCandidate;
            } else {
                return doubleCandidate;
            }
        } else if (verbLastTwoLetters.equals(AP)) {
            if (verb.endsWith(EAP)) {
                return notDoubleCandidate;
            } else {
                return doubleCandidate;
            }
        } else if (verbLastTwoLetters.equals(IT)) {
            if ((verb.endsWith("quit") || verb.endsWith(MIT) || verb.endsWith(FIT)) && isStressOnLastSyllable(wordDefinition)) {
                return doubleCandidate;
            } else {
                return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
            }
        } else if (verb.length() >= 3 && (verb.endsWith(UAT) || verb.endsWith(MAT) || verb.endsWith(BAT))) {
            return doubleCandidate;
        } else if (verbLastTwoLetters.equals(AL)) {
            if (verb.length() >= 3) {
                String verbLastThreeLetters = verb.substring(verb.length() - 3);
                if (Arrays.asList("ial", "ual", "hal", "val", "ral", "nal", "dal", "tal").contains(verbLastThreeLetters)) {
                    if (verb.endsWith("credential")) {
                        return notDoubleCandidate;
                    } else {
                        return doubleCandidate;
                    }
                } else {
                    return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
                }

            } else {
                return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
            }
        } else if (verbLastTwoLetters.equals(IL)) {
            if (verb.length() >= 3) {
                String verbLastThreeLetters = verb.substring(verb.length() - 3);
                if (Arrays.asList(VIL, FIL, CIL, RIL).contains(verbLastThreeLetters)) {
                    return doubleCandidate;
                } else {
                    return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
                }
            } else {
                return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
            }
        } else if (verb.length() >= 3 && verb.endsWith(UIP)) {
            return doubleCandidate;
        } else if (verb.length() >= 3 && verb.endsWith(UIZ)) { // should this be iz ?
            return doubleCandidate;
        } else if (verb.equals(UP)) {
            return doubleCandidate;
        } else {
            // TODO
            return applyDefaultRule(wordDefinition, doubleCandidate, notDoubleCandidate);
        }
    }

    private static String applyDefaultRule(WordDefinition verb, String doubleCandidate, String notDoubleCandidate) {
        if (matchesConsonantVowelConsonantEndingRule(verb.getWord()) && isStressOnLastSyllable(verb)) {
            return doubleCandidate;
        } else {
            return notDoubleCandidate;
        }
    }


    private static boolean matchesEndingWithYConditions(String verb) {
        return endsWithY(verb) && !verb.endsWith("ay") && !verb.endsWith("oy") && !verb.endsWith("ey");
    }

    private static boolean endsWithY(String verb) {
        return verb.endsWith(Y);
    }

    private static boolean matchesConsonantVowelConsonantEndingRule(String word) {
        if (word.length() < 3) {
            return false;
        } else {
            String s1 = word.substring(word.length() - 3, word.length() - 2);
            String s2 = word.substring(word.length() - 2, word.length() - 1);
            String s3 = word.substring(word.length() - 1);
            if (!isVowel(s1) && isVowel(s2) && !isVowel(s3)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean isVowel(String letter) {
        return Arrays.asList(A, E, I, O, U).contains(letter);
    }

    private static String addEndingForPastTense(String verb) {
        if (matchesEndingWithYConditions(verb)) {
            return verb.substring(0, verb.length() - 1) + IED;
        } else {
            return verb.endsWith(E) ? (verb + D) : (verb + ED);
        }
    }

    public static String getPresentTense(String verb, SubjectType subjectType) {
        if (SubjectType.THIRD_PERSON_SINGULAR.equals(subjectType)) {
            if (verb.equals(HAVE)) {
                // The verb to have is a special case ->  "has" for third-person singular
                return verb.substring(0, verb.length() - 2) + S;
            } else if (verb.endsWith(Y) && !verb.endsWith(AY) && !verb.endsWith(OY) && !verb.endsWith(EY) && !verb.endsWith(UY)) {
                // eg. carry
                return verb.substring(0, verb.length() - 1) + IES;
            } else {
                if (verb.endsWith(US)) {
                    // eg. focus - double the last s
                    return verb + SES;
                } else if (verb.endsWith(IZ)) {
                    // quiz
                    return verb + ZES;
                } else if (verb.endsWith(SOOTH) || verb.endsWith(ATH) || verb.endsWith(SH) || verb.endsWith(CH) || verb.endsWith(X)
                        || verb.endsWith(GO) || verb.endsWith(HO) || verb.endsWith(DO) || verb.endsWith(Z) || verb.endsWith(S)) {
                    // soothe, bathe, wash, batch, box, fizz, forgo, echo, do, fuss
                    return verb + ES;
                } else {
                    return verb + S;
                }
            }
        } else {
            // if not third-person singular, just return the verb
            return verb;
        }
    }

    private static String addEndingForPresentParticiple(String verb) {
        if (verb.endsWith(MIE)) {
            return verb + ING;
        } else if (verb.endsWith(IE)) {
            return verb.substring(0, verb.length() - 2) + YING;
        } else if (verb.equals("age")) {
            return verb + ING;
        } else if (verb.endsWith("inge") && !verb.endsWith("ringe")) {
            return verb + ING;
        } else if (verb.endsWith(EE) || verb.endsWith("oe") || verb.endsWith("ye") || ((verb.endsWith("cue") && !verb.endsWith("becue")) && !verb.endsWith("rescue")) || verb.endsWith("eue")) {
            return verb + ING;
        } else if (verb.endsWith(E)) {
            return verb.substring(0, verb.length() - 1) + ING;
        } else {
            return verb + ING;
        }
    }
}
