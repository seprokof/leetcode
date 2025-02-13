import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }, new int[] { 2 }),
                new TestCase(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }, new int[] { 9, 4 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.intersection(test.in1, test.in2);
            assert test.expected.length == actual.length
                    && Objects.equals(toSet(test.expected), toSet(actual)) : "intersection(%s, %s) == %s, want %s"
                            .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                                    Arrays.toString(test.expected));
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || nums1[i] != result[k - 1]) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(result, k);
    }

    private static Set<Integer> toSet(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toSet());
    }

}