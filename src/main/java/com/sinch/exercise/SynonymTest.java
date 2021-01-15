    package com.sinch.exercise;

    import com.google.common.collect.Streams;
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;

    public class SynonymTest
    {
        private static final String[][] EXAMPLE_SYNONYM_PAIRS_RAW = {
            {"approval", "popularity"},
            {"rate", "ratings"}
        };

        private static final String[][] EXAMPLE_CANDIDATE_SENTENCE_PAIRS_RAW = {
            {"trump approval rate", "trump popularity ratings"},
            {"trump approval rates", "trump popularity ratings"},
            {"trump approval rate", "popularity ratings trump"}
        };

        private static final String[][] EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS_RAW = {
            // TODO: define expected test result
        };

        public static final List<SynonymPair> EXAMPLE_SYNONYM_PAIRS = Arrays
            .stream(EXAMPLE_SYNONYM_PAIRS_RAW)
            .map(array -> new SynonymPair(array[0], array[1]))
            .collect(Collectors.toList());
        public static final List<SentencePair> EXAMPLE_CANDIDATE_SENTENCE_PAIRS =
            arraysToSentencePairs(EXAMPLE_CANDIDATE_SENTENCE_PAIRS_RAW);
        public static final List<SentencePair> EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS =
            arraysToSentencePairs(EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS_RAW);

        public static void main( String[] args )
        {
            List<SentencePair> result = new SynonymousFilter(EXAMPLE_SYNONYM_PAIRS).filter(EXAMPLE_CANDIDATE_SENTENCE_PAIRS.stream()).collect(
                Collectors.toList());
            if (EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS.size() == result.size() && Streams.zip(
                EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS.stream(),
                result.stream(),
                (expected, actual) -> expected.left().equals(actual.left()) && expected.right().equals(actual.right())).allMatch(eq -> eq)) {
                System.out.println("Correct result!");
            } else {
                System.out.println("Expected: " + sentencePairsToString(EXAMPLE_SYNONYMOUS_SENTENCE_PAIRS) + "\nBut was: " + sentencePairsToString(result));
            }
        }

        private static List<SentencePair> arraysToSentencePairs(String[][] arrays) {
            return Arrays
                .stream(arrays)
                .map(array -> new SentencePair(
                    Arrays.asList(array[0].split(" ")),
                    Arrays.asList(array[1].split(" "))))
                .collect(Collectors.toList());
        }

        private static String sentencePairsToString(List<SentencePair> sentencePairs) {
            return "{" + String.join("},\n{", sentencePairs.stream().map(pair -> "'" + String.join(" ", pair.left()) + "', '" + String.join(" ", pair.right()) + "'").collect(
                Collectors.toList())) + "}";
        }
    }
