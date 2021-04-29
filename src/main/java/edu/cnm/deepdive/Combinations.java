package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains a single static method, {@link #zeroSumTriplesSlow(int[])}, which scans an {@code
 * int[]} for triplets of values that sum to zero. Implementation of this method is included in the
 * practical exam problems of the Deep Dive Coding Java training programs.
 */
public class Combinations {

  private Combinations() {
    // NOTE: There is NO need to do anything with this constructor! The method
    //       you will implement in this class is static; thus, there is no need
    //       to create instances of this class.
  }

  /**
   * Finds and returns all the zero-sum triplets (3-element {@link Set Set&lt;Integer&gt;}) contained
   * in {@code data}.
   *
   * @param data Values to search.
   * @return All zero-sum triplets in {@code data}.
   */
  public static Set<Set<Integer>> zeroSumTriples(int[] data) {
    Arrays.sort(data);
    Set<Set<Integer>> triples = new HashSet<>();
    for (int i = 0; i < data.length - 2; i++) {
      int front = data[i];
      int j = i + 1;
      int k = data.length - 1;
      while (j < k) {
        int middle = data[j];
        int end = data[k];
        int sum = front + middle + end;
        if (sum == 0) {
          triples.add(Set.of(front, middle, end));
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return triples;
  }

  /**
   * Finds and returns all the zero-sum triplets (3-element {@link Set Set&lt;Integer&gt;}) contained
   * in {@code data}.
   *
   * @param data Values to search.
   * @return All zero-sum triplets in {@code data}.
   */
  public static Set<Set<Integer>> zeroSumTriplesSlow(int[] data) {
    Set<Set<Integer>> zeroTriplets = new HashSet<>();
    for (int i = 0; i < data.length - 2; i++) {
      for (int j = i + 1; j < data.length - 1; j++) {
        for (int k = j + 1; k < data.length; k++) {
          if (data[i] + data[j] + data[k] == 0) {
            zeroTriplets.add(Set.of(data[i], data[j], data[k]));
          }
        }
      }
    }
    return zeroTriplets;
  }

}
