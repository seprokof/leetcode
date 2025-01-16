import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 2, 3, null, 5, null, 4 }), List.of(1, 3, 4)),
                new TestCase(makeTree(new Integer[] { 1, 2, 3, 4, null, null, null, 5 }), List.of(1, 3, 4, 5)),
                new TestCase(makeTree(new Integer[] { 1, null, 3 }), List.of(1, 3)),
                new TestCase(makeTree(new Integer[] { }), List.of())
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.rightSideView(test.in);
            assert test.expected.equals(actual) : "rightSideView(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        List<Integer> rightResult = rightSideView(root.right);
        List<Integer> leftResult = rightSideView(root.left);
        result.addAll(rightResult);
        for (int i = rightResult.size(); i < leftResult.size(); i++) {
            result.add(leftResult.get(i));
        }
        return result;
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