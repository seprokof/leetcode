import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }, List.of(List.of(1, 3), List.of(4, 6))),
                new TestCase(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }, List.of(List.of(3), List.of()))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.findDifference(test.in1, test.in2);
            for (int i = 0; i < actual.size(); i++) {
                List<Integer> expectedItem = new ArrayList<>(test.expected.get(i));
                List<Integer> actualItem = actual.get(i);
                Collections.sort(expectedItem);
                Collections.sort(actualItem);
                assert expectedItem.equals(actualItem) : "findDifference(%s, %s) == %s, want %s"
                        .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
            }
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        IntStream.of(nums1).boxed().collect(Collectors.toCollection(() -> nums1Set));
        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        IntStream.of(nums2).boxed().collect(Collectors.toCollection(() -> nums2Set));
        return List.of(
                nums1Set.stream().filter(Predicate.not(nums2Set::contains))
                        .collect(Collectors.toCollection(ArrayList::new)),
                nums2Set.stream().filter(Predicate.not(nums1Set::contains))
                        .collect(Collectors.toCollection(ArrayList::new)));
    }

}