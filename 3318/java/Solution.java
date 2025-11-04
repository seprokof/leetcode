import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2, new int[] { 6, 10, 12 }),
                new TestCase(new int[] { 3, 8, 7, 8, 7, 5 }, 2, 2, new int[] { 11, 15, 15, 15, 12 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findXSum(test.in1, test.in2, test.in3);
            assert Arrays.equals(test.expected, actual) : "findXSum(%s, %s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, test.in3, Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    private static final Comparator<int[]> COMP = (l, r) -> l[1] == r[1] ? r[0] - l[0] : r[1] - l[1];

    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> freq = new HashMap<>(50);
        for (int i = 0; i < k; i++) {
            freq.merge(nums[i], 1, Integer::sum);
        }
        int[] answer = new int[nums.length - k + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = xSum(freq, x);
            if (i + k < nums.length) {
                freq.merge(nums[i], -1, Integer::sum);
                freq.merge(nums[i + k], 1, Integer::sum);
            }
        }
        return answer;
    }

    private static int xSum(Map<Integer, Integer> frequency, int x) {
        int sum = 0;
        if (frequency.size() < x) {
            for (Entry<Integer, Integer> en : frequency.entrySet()) {
                sum += en.getKey() * en.getValue();
            }
        } else {
            List<int[]> sorted = new ArrayList<>(frequency.size());
            for (Entry<Integer, Integer> en : frequency.entrySet()) {
                sorted.add(new int[] { en.getKey(), en.getValue() });
            }
            Collections.sort(sorted, COMP);
            for (int i = 0; i < x && i < sorted.size(); i++) {
                sum += sorted.get(i)[0] * sorted.get(i)[1];
            }
        }
        return sum;
    }

}