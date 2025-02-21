import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 1, 1 }, 1),
                new TestCase(new int[] { 1, 2 }, new int[] { 1, 2, 3 }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findContentChildren(test.in1, test.in2);
            assert test.expected == actual : "findContentChildren(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int happyChildren = 0;
        int gIdx = 0;
        int sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                happyChildren++;
                gIdx++;
            }
            sIdx++;
        }
        return happyChildren;
    }

}