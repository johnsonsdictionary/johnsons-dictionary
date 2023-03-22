package io.github.johnsonsdictionary.verbs.conjugation.regular.base;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.base.VerbConjugatorTestBase;
import io.github.johnsonsdictionary.verbs.conjugation.regular.RegularVerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.util.VerbConjugationCSVReader;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class RegularVerbConjugatorTestBase extends VerbConjugatorTestBase {


    protected final static String EXPECTED_CONJUGATED_JOHNSONS_ALL_VERBS_FILE_PATH = "/english/regular/en-GB/johnsons_regular_verbs_conjugations.csv";

    protected final static String EXPECTED_CONJUGATED_JOHNSONS_ALL_MULTI_WORD_VERBS_FILE_PATH = "/english/regular/en-GB/johnsons_multi_word_verbs_conjugations.csv";

    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_A_FILE_PATH = "/english/regular/en-GB/regular_verbs_a_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_B_FILE_PATH = "/english/regular/en-GB/regular_verbs_b_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_C_FILE_PATH = "/english/regular/en-GB/regular_verbs_c_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_D_FILE_PATH = "/english/regular/en-GB/regular_verbs_d_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_E_FILE_PATH = "/english/regular/en-GB/regular_verbs_e_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_F_FILE_PATH = "/english/regular/en-GB/regular_verbs_f_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_G_FILE_PATH = "/english/regular/en-GB/regular_verbs_g_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_H_FILE_PATH = "/english/regular/en-GB/regular_verbs_h_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_I_FILE_PATH = "/english/regular/en-GB/regular_verbs_i_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_J_FILE_PATH = "/english/regular/en-GB/regular_verbs_j_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_K_FILE_PATH = "/english/regular/en-GB/regular_verbs_k_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_L_FILE_PATH = "/english/regular/en-GB/regular_verbs_l_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_M_FILE_PATH = "/english/regular/en-GB/regular_verbs_m_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_N_FILE_PATH = "/english/regular/en-GB/regular_verbs_n_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_O_FILE_PATH = "/english/regular/en-GB/regular_verbs_o_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_P_FILE_PATH = "/english/regular/en-GB/regular_verbs_p_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_Q_FILE_PATH = "/english/regular/en-GB/regular_verbs_q_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_R_FILE_PATH = "/english/regular/en-GB/regular_verbs_r_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_S_FILE_PATH = "/english/regular/en-GB/regular_verbs_s_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_T_FILE_PATH = "/english/regular/en-GB/regular_verbs_t_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_U_FILE_PATH = "/english/regular/en-GB/regular_verbs_u_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_V_FILE_PATH = "/english/regular/en-GB/regular_verbs_v_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_W_FILE_PATH = "/english/regular/en-GB/regular_verbs_w_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_X_FILE_PATH = "/english/regular/en-GB/regular_verbs_x_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_Y_FILE_PATH = "/english/regular/en-GB/regular_verbs_y_conjugations.csv";
    protected final static String EXPECTED_CONJUGATED_VERBS_STARTING_WITH_Z_FILE_PATH = "/english/regular/en-GB/regular_verbs_z_conjugations.csv";

    public RegularVerbConjugatorTestBase(VerbConjugator<VerbConjugation> verbConjugator) {
        super(verbConjugator);
    }

    protected void testVerbConjugation(SortedMap<WordDefinitionId, WordDefinition> verbs, String expectedResultsFilePaths) {
        testVerbConjugation(verbs, Arrays.asList(expectedResultsFilePaths));
    }


        protected void testVerbConjugation(SortedMap<WordDefinitionId, WordDefinition> verbs, List<String> expectedResultsFilePaths) {

        VerbConjugator<VerbConjugation> regularVerbConjugator = VerbConjugators.REGULAR_VERB_CONJUGATOR;

        SortedMap<WordDefinitionId, RegularVerbConjugation> expectedConjugatedVerbs =
                new VerbConjugationCSVReader<>((i, v) ->
                        new RegularVerbConjugation(v.get(0), i.getMeaningId(), getValuesFromVariables(v, "past_tense", false), getValuesFromVariables(v, "present_participle", true)),
                        false, expectedResultsFilePaths).load();

        testVerbConjugation(expectedConjugatedVerbs, verbs);
    }
}
