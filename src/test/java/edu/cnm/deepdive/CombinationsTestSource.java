package edu.cnm.deepdive;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class CombinationsTestSource {

  static Stream<Arguments> zeroSumTriples() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 2, 5, 3, 0, 4, 1}, Set.of()),
        Arguments.of(new int[]{1, 0, -2, 4, -3, -1, 3}, Set.of(Set.of(-1, 0, 1), Set.of(-3, 0, 3), Set.of(-3, -1, 4), Set.of(-2, -1, 3)))
    );
  }
}
