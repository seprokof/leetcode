
class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }, 0),
                new TestCase(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countStudents(test.in1, test.in2);
            assert test.expected == actual : "countStudents('%s', %s) == '%s', want '%s'".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int circle = 0;
        int square = 0;
        for (int student : students) {
            if (student == 0) {
                circle++;
            } else {
                square++;
            }
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (circle == 0) {
                    return square;                    
                } else {
                    circle--;
                }
            } else {
                if (square == 0) {
                    return circle;
                } else {
                    square--;
                }
            }
        }
        return 0;
    }

}