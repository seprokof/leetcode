import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, List<String> in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("BCD", List.of("BCC", "CDE", "CEA", "FFF"), true),
                new TestCase("AAAA", List.of("AAB", "AAC", "BCD", "BBE", "DEF"), false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.pyramidTransition(test.in1, test.in2);
            assert test.expected == actual : "pyramidTransition('%s', %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    private final Map<String, List<String>> allowedToResult = new HashMap<>();
    private final Map<String, Boolean> cache = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String a : allowed) {
            allowedToResult.computeIfAbsent(a.substring(0, 2), ignore -> new ArrayList<>()).add(a.substring(2));
        }
        return generateNextLevel(new StringBuilder(bottom), new StringBuilder());
    }

    private boolean generateNextLevel(StringBuilder currentLevel, StringBuilder nextLevel) {
        String cacheKey = currentLevel + "_" + nextLevel;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        if (currentLevel.length() == 1) {
            cache.put(cacheKey, true);
            return true;
        }
        int len = nextLevel.length();
        if (len == currentLevel.length() - 1) {
            return generateNextLevel(nextLevel, new StringBuilder());
        }
        String base = currentLevel.substring(len, len + 2);
        List<String> tops = allowedToResult.get(base);
        if (tops == null) {
            cache.put(cacheKey, false);
            return false;
        }
        for (String top : tops) {
            nextLevel.append(top);
            if (generateNextLevel(currentLevel, nextLevel)) {
                cache.put(cacheKey, true);
                return true;
            }
            nextLevel.setLength(len);
        }
        cache.put(cacheKey, false);
        return false;
    }

}