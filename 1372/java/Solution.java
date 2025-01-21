import java.util.ArrayList;
import java.util.List;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(TreeNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1 }), 3),
                new TestCase(makeTree(new Integer[] { 1, 1, 1, null, 1, null, null, 1, 1, null, 1 }), 4),
                new TestCase(makeTree(new Integer[] { 1 }), 0)
                };
         // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int actual = s.longestZigZag(test.in);
			assert test.expected == actual
					: "longestZigZag(%s) == %s, want %s".formatted(test.in, actual, test.expected);
		}
	}

	public int longestZigZag(TreeNode root) {
		return Math.max(traverse(root.left, true, 1), traverse(root.right, false, 1));
	}

	private static int traverse(TreeNode node, boolean isLeft, int length) {
		if (node == null) {
			return --length;
		}
		if (node.left == null && node.right == null) {
			return length;
		}
		length++;
		if (isLeft) {
			return Math.max(traverse(node.right, false, length), traverse(node.left, true, 1));
		} else {
			return Math.max(traverse(node.left, true, length), traverse(node.right, false, 1));
		}
	}

	private static TreeNode makeTree(Integer[] values) {
		if (values.length < 1) {
			return null;
		}
		TreeNode root = new TreeNode(values[0]);
		List<TreeNode> prevLevel = List.of(root);
		int i = 1;
		while (i < values.length) {
			List<TreeNode> currentLevel = new ArrayList<>(prevLevel.size() * 2);
			for (int j = 0; j < prevLevel.size() && i < values.length; j++) {
				if (values[i] != null) {
					TreeNode leftNode = new TreeNode(values[i]);
					prevLevel.get(j).left = leftNode;
					currentLevel.add(leftNode);
				}
				i++;
				if (i < values.length) {
					if (values[i] != null) {
						TreeNode rightNode = new TreeNode(values[i]);
						prevLevel.get(j).right = rightNode;
						currentLevel.add(rightNode);
					}
					i++;
				}
			}
			prevLevel = currentLevel;
		}
		return root;
	}

}