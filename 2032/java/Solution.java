import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] in3, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 3, 2 }, new int[] { 2, 3 }, new int[] { 3 }, List.of(3, 2)),
                new TestCase(new int[] { 3, 1 }, new int[] { 2, 3 }, new int[] { 1, 2 }, List.of(2, 3, 1)),
                new TestCase(new int[] { 1, 2, 2 }, new int[] { 4, 3, 3 }, new int[] { 5 }, List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.twoOutOfThree(test.in1, test.in2, test.in3);
            assert containsSameElements(test.expected, actual) : "twoOutOfThree(%s, %s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(test.in3), actual,
                    test.expected);
        }
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] flags1 = hasNumber(nums1);
        int[] flags2 = hasNumber(nums2);
        int[] flags3 = hasNumber(nums3);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (flags1[i] + flags2[i] + flags3[i] > 1) {
                result.add(i);
            }
        }
        return result;
    }

    private static int[] hasNumber(int[] array) {
        int[] flags = new int[101];
        for (int v : array) {
            flags[v] = 1;
        }
        return flags;
    }

    private static boolean containsSameElements(List<Integer> list1, List<Integer> list2) {
        if (list1 == null) {
            return list2 == null;
        }
        if (list2 == null) {
            return list1 == null;
        }
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }

}