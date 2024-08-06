package com.sinch.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

public class SynonymousFilter {

  public List<Pair<String, String>> synonymPairs;

  HashMap<String, String> map = new HashMap<>();

  public SynonymousFilter(List<Pair<String, String>> synonymPairs) {
    // TODO: implement
    this.synonymPairs = synonymPairs;
    synonymPairs.forEach(pair -> {
      this.map.putIfAbsent(pair.getLeft(), pair.getRight());
    });
  }

  /**
   * Filter a list of sentence pairs, removing those that are not synonymous.
   *
   * @param sentencePairs A list of sentence pairs, either synonymous or not
   * @return A list consisting of only the synonymous sentence pairs
   */
  public List<Pair<String, String>> filter(List<Pair<String, String>> sentencePairs) {
    List<Pair<String, String>> result = new ArrayList();
    // TODO: implement
    sentencePairs.forEach(sentencePair -> {
      if (addPair(sentencePair))
        result.add(sentencePair);
    });
    result.forEach(r -> System.out.println(r.getLeft() + " -- " + r.getRight()));
    return result;
  }

  public boolean addPair(Pair<String, String> sentencePair) {
    var leftWords = sentencePair.getLeft().trim().split(" ");
    var rightWords = sentencePair.getRight().trim().split(" ");
    if (leftWords.length == rightWords.length) {
      for (int i = 0; i < rightWords.length; i++) {
        var lWord = leftWords[i];
        var rWord = rightWords[i];
        // The filter logic
        if (!(lWord.equals(rWord)
            || (this.map.containsKey(lWord) && this.map.get(lWord).equals(rWord))
            || (this.map.containsKey(rWord) && this.map.get(rWord).equals(lWord)))) {
              // this flag is used to check which pair I should add since I am inside another scope
              return false;
        }

      }
    }
    return true;
  }

  /**
   * Filter a stream of sentence pairs, removing those that are not synonymous.
   *
   * @param candidateSentencePairs A stream of sentence pairs, either synonymous
   *                               or not
   * @return A stream consisting of only the synonymous sentence pairs
   */
  public Stream<Pair<String, String>> filter(Stream<Pair<String, String>> candidateSentencePairs) {
    // TODO: implement
    return Stream.empty();
  }
}