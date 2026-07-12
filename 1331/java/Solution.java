import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 40, 10, 20, 30 }, new int[] { 4, 1, 2, 3 }),
                new TestCase(new int[] { 100, 100, 100 }, new int[] { 1, 1, 1 }),
                new TestCase(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 }, new int[] { 5, 3, 4, 2, 8, 6, 7, 1, 3 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.arrayRankTransform(test.in);
            assert Arrays.equals(test.expected, actual) : "arrayRankTransform(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        System.arraycopy(arr, 0, result, 0, len);
        Arrays.sort(result);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer v = result[i];
            if (!map.containsKey(v)) {
                map.put(v, rank++);
            }
        }
        for (int i = 0; i < len; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

}