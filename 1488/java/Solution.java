import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, new int[] { -1, -1, -1, -1 }),
                new TestCase(new int[] { 1, 2, 0, 0, 2, 1 }, new int[] { -1, -1, 2, 1, -1, -1 }),
                new TestCase(new int[] { 1, 2, 0, 1, 2 }, new int[] { })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.avoidFlood(test.in);
            assert Arrays.equals(test.expected, actual) : "avoidFlood(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lastRainByLake = new HashMap<>();
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                ans[i] = -1;
                Integer lastRain = lastRainByLake.get(lake);
                if (lastRain != null) {
                    Integer closestSunnyDay = sunnyDays.ceiling(lastRain);
                    if (closestSunnyDay == null) {
                        return new int[] {};
                    }
                    ans[closestSunnyDay] = lake;
                    sunnyDays.remove(closestSunnyDay);
                }
                lastRainByLake.put(lake, i);
            } else {
                ans[i] = 1;
                sunnyDays.add(i);
            }
        }
        return ans;
    }

}