import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, TreeNode in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 3, 5, 1, 6, 2, 9, 8, null, null, 7, 4 }), makeTree(new Integer[] { 3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8 }), true),
                new TestCase(makeTree(new Integer[] { 1, 2, 3 }), makeTree(new Integer[] { 1, 3, 2 }), false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.leafSimilar(test.in1, test.in2);
            assert test.expected == actual : "leafSimilar(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        getLeaves(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root2, leaves2);
        return Objects.equals(leaves1, leaves2);
    }

    private static void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            getLeaves(root.left, leaves);
            getLeaves(root.right, leaves);
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