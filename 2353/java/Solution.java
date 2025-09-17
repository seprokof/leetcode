import java.util.Objects;

class Solution {

    private static final String CTOR = "FoodRatings";
    private static final String CHANGE = "changeRating";
    private static final String GET = "highestRated";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, Object[][] in2, String[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { CTOR, GET, GET, CHANGE, GET, CHANGE, GET }, new Object[][] { { new String[] { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" }, new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" }, new int[] { 9, 12, 8, 15, 14, 7 } }, { "korean" }, { "japanese" }, { "sushi", 16 }, { "japanese" }, { "ramen", 16 }, { "japanese" } }, new String[] { null, "kimchi", "ramen", null, "sushi", null, "ramen" })
                };
        // @formatter:on

        for (TestCase test : tests) {
            FoodRatings f = null;
            for (int i = 0; i < test.in1.length; i++) {
                if (CTOR.equals(test.in1[i])) {
                    f = new FoodRatings((String[]) test.in2[i][0], (String[]) test.in2[i][1], (int[]) test.in2[i][2]);
                } else if (CHANGE.equals(test.in1[i])) {
                    f.changeRating((String) test.in2[i][0], (int) test.in2[i][1]);
                } else if (GET.equals(test.in1[i])) {
                    String actual = f.highestRated((String) test.in2[i][0]);
                    assert Objects.equals(test.expected[i], actual) : GET
                            + "('%s') == '%s', want '%s'".formatted(test.in2[i][0], actual, test.expected[i]);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}