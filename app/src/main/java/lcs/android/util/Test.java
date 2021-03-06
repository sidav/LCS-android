/**
 *
 */
package lcs.android.util;

// import org.eclipse.jdt.annotation.NonNullByDefault;
// import org.eclipse.jdt.annotation.Nullable;

/** @author addie */
public class Test {
  public static <T> T nonNull(T test) {
    if (test == null) {
      throw new IllegalArgumentException("Must not be null");
    }
    return test;
  }
}
