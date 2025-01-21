import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 1, 4, 3, null, 1, 5 }), 4),
                new TestCase(makeTree(new Integer[] { 3, 3, null, 4, 2 }), 3),
                new TestCase(makeTree(new Integer[] { 1 }), 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.goodNodes(test.in);
            assert test.expected == actual : "goodNodes(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private static int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= max) {
            result++;
            max = root.val;
        }
        return result + goodNodes(root.left, max) + goodNodes(root.right, max);
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