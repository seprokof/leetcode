import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int[][] in3, int expected) {}

        TestCase[] tests = {
                new TestCase(2, new int[][] { { 1 }, { 2 }, { 1, 2 } }, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }, 1),
                new TestCase(3, new int[][] { { 2 }, { 1, 3 }, { 1, 2 }, { 3 } }, new int[][] { { 1, 4 }, { 1, 2 }, { 3, 4 }, { 2, 3 } }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumTeachings(test.in1, test.in2, test.in3);
            assert test.expected == actual : "minimumTeachings(%s, %s, %s) = %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), Arrays.deepToString(test.in3), actual, test.expected);
        }
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> disconnectedUsers = new HashSet<>();
        for (int[] friends : friendships) {
            if (!hasCommonLang(languages[friends[0] - 1], languages[friends[1] - 1])) {
                disconnectedUsers.add(friends[0] - 1);
                disconnectedUsers.add(friends[1] - 1);
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int popularLang = 0;
        for (Integer userIdx : disconnectedUsers) {
            for (int lang : languages[userIdx]) {
                popularLang = Math.max(popularLang, freq.merge(lang, 1, Integer::sum));
            }
        }
        return disconnectedUsers.size() - popularLang;
    }

    private static boolean hasCommonLang(int[] langs1, int[] langs2) {
        for (int l1 : langs1) {
            for (int l2 : langs2) {
                if (l1 == l2) {
                    return true;
                }
            }
        }
        return false;
    }

}