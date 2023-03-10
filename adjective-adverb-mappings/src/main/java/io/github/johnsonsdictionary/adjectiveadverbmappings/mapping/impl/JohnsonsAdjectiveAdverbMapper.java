package io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.impl;


import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.AdjectiveAdverbMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JohnsonsAdjectiveAdverbMapper implements AdjectiveAdverbMapper {

    private final static String D = "d";
    private final static String R = "r";
    private final static String O = "o";
    private final static String W = "w";
    private final static String A = "a";
    private final static String L = "l";
    private final static String I = "i";
    private final static String B = "b";
    private final static String C = "c";
    private final static String Y = "y";

    private final static String K = "k";

    private final static String E = "e";

    private final static String S = "s";

    private final static String UE = "ue";
    private final static String IE = "ie";
    private final static String DUE = D + UE;
    private final static String RUE = R + UE;
    private final static String RIE = R + IE;
    private final static String OY = O + Y;
    private final static String RY = R + Y;

    private final static String DRY = D + RY;
    private final static String WRY = W + RY;

    private final static String LE = L + E;
    private final static String LY = L + Y;

    private final static String LL = L + L;

    private final static String AL = A + L;
    private final static String ALLY = AL + LY;
    private final static String ILY = I + LY;

    private final static String OLE = O + LE;

    private final static String SOLE = S + OLE;


    private final static String SLY = S + LY;

    private final static String IC = I + C;

    private final static String ICK = IC + K;


    private final static String BL = B + L;
    private final static String BLIC = BL + IC;

    private final static String LESS = LE + S + S;

    private final static String F = "f";

    private final static String T = "t";


    @Override
    public List<String> getAdverbsFromAdjective(String adjective) {

        // One of the trailing s characters is dropped before adding "ly"
        // for these cases
        List<String> LESS_SPECIAL_CASES = Arrays.asList("artless",
                "blameless", "careless", "causeless", "fearless",
                "lawless", "lifeless", "listless", "pitiless", "regardless",
                "restless", "ruthless");

        // These get ending-specific mappings, plus the default mapping of adding "ly"
        // Some of which are nouns
        List<String> ADDITIONAL_DEFAULT_SPECIAL_CASES = Arrays.asList("gay",
                "frantick", "publick", "heroick", "frolick",
                "politick", "impolitick", "authentick", "brainsick");

        // THese just get "ly" added, overriding any other special case mapping
        // Some of which are nouns
        List<String> DEFAULT_SPECIAL_CASE_OVERRIDES = Arrays.asList("antick", "relick", "frantick", "publick",
                "frolick");

        List<String> mappedAdverbs = new ArrayList<>();
        if (!DEFAULT_SPECIAL_CASE_OVERRIDES.contains(adjective)) {
            if (adjective.endsWith(SOLE)) {
                // sole
                mappedAdverbs.add(adjective + LY);
            } else if (adjective.endsWith(DUE) || adjective.endsWith(RUE) || adjective.endsWith(RIE) || adjective.endsWith(OLE)) {
                // due, eerie, true, undue, whole
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + LY);
            } else if (adjective.equals("pale") || adjective.equals("stale")) {
                mappedAdverbs.add(adjective + LY);
            } else if (adjective.endsWith("vile")) {
                mappedAdverbs.add(adjective + LY);
            } else if (adjective.endsWith(LE)) {
                // covers ble, ple, tle
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + Y);
            } else if (adjective.endsWith(IC) && !adjective.endsWith(BLIC)) { // excludes public, but includes symbolic
                mappedAdverbs.add(adjective + ALLY);
            } else if (adjective.endsWith(RY) && !adjective.endsWith(DRY) && !adjective.endsWith(WRY)) { // excludes public, but includes symbolic
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + ILY);
            } else if (adjective.endsWith(Y) && !adjective.endsWith(OY) && !adjective.endsWith(RY) && !adjective.endsWith(SLY)) { // slyly
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + ILY);
            } else if (adjective.endsWith(LL)) { // full/fully
                mappedAdverbs.add(adjective + Y);
            } else if (adjective.endsWith(ICK) && !adjective.equals("presentifick") && !adjective.equals("quick") && !adjective.equals("thick") && !adjective.equals("sick") && !adjective.equals("brainsick")) {
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + ALLY);
            } else if (adjective.endsWith(LESS) && LESS_SPECIAL_CASES.contains(adjective)) {
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + LY);
            } else if (adjective.endsWith("the") || adjective.endsWith("ste") || adjective.equals("adverse")) {
                mappedAdverbs.add(adjective.substring(0, adjective.length() - 1) + LY);
            }
        }

        // Default mapping
        if (mappedAdverbs.isEmpty() || ADDITIONAL_DEFAULT_SPECIAL_CASES.contains(adjective) || DEFAULT_SPECIAL_CASE_OVERRIDES.contains(adjective)) {
            mappedAdverbs.add(adjective + LY);
        }
        return mappedAdverbs;
    }

    @Override
    public List<String> getAdjectivesFromAdverb(String adverb) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
