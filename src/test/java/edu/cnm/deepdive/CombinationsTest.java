package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CombinationsTest {

  @ParameterizedTest
  @MethodSource("edu.cnm.deepdive.CombinationsTestSource#zeroSumTriples")
  void zeroSumDoubles(int[] input, Set<Set<Integer>> expected) {
    assertEquals(expected, Combinations.zeroSumTriples(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting zeroSumTriplesSlow({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.CombinationsTestSource#zeroSumTriples")
  void zeroSumTriplesSlow(int[] input, Set<Set<Integer>> expected) {
    assertTrue(equals(expected, Combinations.zeroSumTriplesSlow(input)));
  }

  private static boolean equals(Set<?> set1, Set<?> set2) {
    if (set1 == null || set2 == null || set1.size() != set2.size()) {
      return false;
    }
    //noinspection SuspiciousMethodCalls
    return set1.containsAll(set2);
  }

}