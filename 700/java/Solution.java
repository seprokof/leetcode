import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in1, int in2, TreeNode expected) {}

        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 4, 2, 7, 1, 3 }), 2, makeTree(new Integer[] { 2, 1, 3 })),
                new TestCase(makeTree(new Integer[] { 4, 2, 7, 1, 3 }), 5, makeTree(new Integer[] { }))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.searchBST(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "searchBST(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
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