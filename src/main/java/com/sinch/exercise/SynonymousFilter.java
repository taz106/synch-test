package com.sinch.exercise;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

public class SynonymousFilter {

  public SynonymousFilter(List<Pair<String, String>> synonymPairs) {
    // TODO: implement
  }

  /**
   * Filter a list of sentence pairs, removing those that are not synonymous.
   *
   * @param sentencePairs A list of sentence pairs, either synonymous or not
   * @return A list consisting of only the synonymous sentence pairs
   */
  public List<Pair<String, String>> filter(List<Pair<String, String>> sentencePairs) {
    // TODO: implement
    return Collections.emptyList();
  }

  /**
   * Filter a stream of sentence pairs, removing those that are not synonymous.
   *
   * @param candidateSentencePairs A stream of sentence pairs, either synonymous or not
   * @return A stream consisting of only the synonymous sentence pairs
   */
  public Stream<Pair<String, String>> filter(Stream<Pair<String, String>> candidateSentencePairs) {
    // TODO: implement
    return Stream.empty();
  }
}