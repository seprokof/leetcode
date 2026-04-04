import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("ch   ie   pr", 3, "cipher"),
                new TestCase("iveo    eed   l te   olc", 4, "i love leetcode"),
                new TestCase("coding", 1, "coding")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.decodeCiphertext(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "decodeCiphertext('%s', %s) = '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;

        }
        char[][] matrix = new char[rows][];
        int cols = (int) Math.ceil((double) encodedText.length() / rows);
        for (int row = 0; row < rows; row++) {
            matrix[row] = encodedText.substring(row * cols, (row + 1) * cols).toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < matrix.length && col + row < cols; row++) {
                sb.append(matrix[row][col + row]);
            }
        }
        return sb.toString().stripTrailing();
    }

}