package io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.impl;


import io.github.johnsonsdictionary.verbadverbmappings.mapping.ConjugatedVerbAdverbMapper;

import java.util.Arrays;
import java.util.List;

public class JohnsonsConjugatedVerbAdverbMapper implements ConjugatedVerbAdverbMapper {

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
    public List<String> getAdverbsFromConjugatedVerb(String conjugatedVerb) {
        return Arrays.asList(conjugatedVerb + LY);
    }

    @Override
    public List<String> getConjugatedVerbFromAdjective(String adverb) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
