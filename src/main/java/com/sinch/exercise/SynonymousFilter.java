  package com.sinch.exercise;

  import java.util.Collections;
  import java.util.HashMap;
  import java.util.LinkedHashMap;
  import java.util.List;
  import java.util.ArrayList;
  import java.util.stream.Collectors;
  import java.util.stream.Stream;

  public class SynonymousFilter {

    private HashMap<String, String> synonymPairMap;

    public SynonymousFilter(List<SynonymPair> synonymPairs) {
      // TODO: implement
    }

    /**
     * Filter a list of sentence pairs, removing those that are not synonymous.
     * @param candidateSentencePairs A list of sentence pairs, either synonymous or not
     * @return A list consisting of only the synonymous sentence pairs
     */
    public List<SentencePair> filter(List<SentencePair> candidateSentencePairs) {
      // TODO: implement either this one or both this and the streaming filter method
      return Collections.emptyList();
    }

    /**
     * Filter a stream of sentence pairs, removing those that are not synonymous.
     * @param candidateSentencePairs A stream of sentence pairs, either synonymous or not
     * @return A stream consisting of only the synonymous sentence pairs
     */
    public Stream<SentencePair> filter(Stream<SentencePair> candidateSentencePairs) {
      // TODO: optionally implement this filter method for a streaming filter
      return Stream.empty();
    }
  }
