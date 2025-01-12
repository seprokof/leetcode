import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(char[] in, int expected1, char[] expected2) {}

        TestCase[] tests = {
                new TestCase(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }, 6, new char[] { 'a', '2', 'b', '2', 'c', '3' }),
                new TestCase(new char[] { 'a' }, 1, new char[] { 'a' }),
                new TestCase(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }, 4, new char[] { 'a', 'b', '1', '2' })
                };
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			char[] in = Arrays.copyOf(test.in, test.in.length);
			int actual1 = s.compress(in);
			char[] actual2 = Arrays.copyOf(in, actual1);
			assert actual1 == test.expected1 && Arrays.equals(test.expected2, actual2)
					: "compress(%s) == %s (%s), want %s (%s)".formatted(Arrays.toString(test.in), actual1,
							Arrays.toString(actual2), test.expected1, Arrays.toString(test.expected2));
		}
	}

	public int compress(char[] chars) {
		char current = chars[0];
		int numCopies = 0;
		int j = 0; // real index in result array
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == current) {
				numCopies++;
				continue;
			}
			chars[j++] = current;
			if (numCopies > 0) {
				for (char ch : String.valueOf(++numCopies).toCharArray()) {
					chars[j++] = ch;
				}
				numCopies = 0;
			}
			current = chars[i];
		}
		chars[j++] = current;
		if (numCopies > 0) {
			for (char ch : String.valueOf(++numCopies).toCharArray()) {
				chars[j++] = ch;
			}
		}
		return j;
	}

	public int compress1(char[] chars) {
		if (chars.length == 1) {
			return 1;
		}
		char current = chars[0];
		int numCopies = 0;
		int j = 0; // real index in result array
		for (int i = 1; i < chars.length; i++) {
			System.out.println("i=" + i);
			if (chars[i] == current) {
				numCopies++;
				if (i != chars.length - 1) {
					continue;
				}
			}
			System.out.println(Arrays.toString(chars));
			chars[j] = current;
			j++;
			System.out.println(Arrays.toString(chars));
			System.out.println("j=" + j);
			System.out.println("numCopies=" + numCopies);
			if (numCopies > 0) {
				for (char ch : String.valueOf(++numCopies).toCharArray()) {
					chars[j] = ch;
					j++;
				}
			}
			current = chars[i];
			numCopies = 0;
		}
		System.out.println(Arrays.toString(chars));
		j++;
		return j;
	}

}