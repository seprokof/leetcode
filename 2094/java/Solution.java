import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3, 0 }, new int[] { 102, 120, 130, 132, 210, 230, 302, 310, 312, 320 }),
                new TestCase(new int[] { 2, 2, 8, 8, 2 }, new int[] { 222, 228, 282, 288, 822, 828, 882 }),
                new TestCase(new int[] { 3, 7, 5 }, new int[] { })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findEvenNumbers(test.in);
            assert Arrays.equals(test.expected, actual) : "findEvenNumbers(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] frequency = new int[10];
        boolean hasEven = false;
        for (int digit : digits) {
            frequency[digit]++;
            hasEven |= digit % 2 == 0;
        }
        if (!hasEven) {
            return new int[] {};
        }
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i < frequency.length; i++) {
            if (--frequency[i] >= 0) {
                for (int j = 0; j < frequency.length; j++) {
                    if (--frequency[j] >= 0) {
                        for (int k = 0; k < frequency.length; k += 2) {
                            if (frequency[k] > 0) {
                                values.add(i * 100 + j * 10 + k);
                            }
                        }
                    }
                    frequency[j]++;
                }
            }
            frequency[i]++;
        }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }

}