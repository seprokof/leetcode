import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, int expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, 2, 3, 4, 5, 6 }), 6),
                new TestCase(makeTree(new Integer[] { }), 0),
                new TestCase(makeTree(new Integer[] { 1 }), 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countNodes(test.in);
            assert test.expected == actual : "countNodes(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        if (height < 0) {
            return 0;
        }
        if (getHeight(root.right) == height - 1) {
            return (int) Math.pow(2, height) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, height - 1) + countNodes(root.left);
        }
    }

    private static int getHeight(TreeNode node) {
        return node == null ? -1 : getHeight(node.left) + 1;
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