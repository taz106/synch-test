package com.sinch.exercise;

import com.google.common.collect.Streams;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

public class SynonymTest {

  private static final List<Pair<String, String>> SYNONYMS =
      Arrays.asList(
          Pair.of("approval", "popularity"),
          Pair.of("rate", "ratings")
      );

  private static final List<Pair<String, String>> SENTENCES =
      Arrays.asList(
          Pair.of("trump approval rate", "trump popularity ratings"),
          Pair.of("trump approval rates", "trump popularity ratings"),
          Pair.of("trump approval rate", "popularity ratings trump")
      );

  private static final List<Pair<String, String>> EXPECTATION = Collections
      .emptyList(); // TODO: define expected test result

  public static void main(String[] args) {
    try {
      List<Pair<String, String>> result = new SynonymousFilter(SYNONYMS).filter(SENTENCES);
      if (EXPECTATION.size() == result.size() && Streams.zip(
          SENTENCES.stream(),
          result.stream(),
          (expected, actual) -> expected.getKey().equals(actual.getKey()) && expected.getValue()
              .equals(actual.getValue())).allMatch(eq -> eq)) {
        System.out.println("Correct result!");
      } else {
        System.out.println(
            "Expected: " + sentencesToString(SENTENCES) + "\nBut was: " + sentencesToString(
                result));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String sentencesToString(List<Pair<String, String>> sentences) {
    return "{" + String.join("},\n{", sentences.stream().map(
        pair -> "'" + String.join(" ", pair.getKey()) + "', '" + String.join(" ", pair.getValue())
            + "'").collect(
        Collectors.toList())) + "}";
  }
}
