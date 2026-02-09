import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(TreeNode in, Set<TreeNode> expected) {}
        
        TestCase[] tests = {
                new TestCase(makeTree(new Integer[] { 1, null, 2, null, 3, null, 4, null, null }), Set.of(makeTree(new Integer[] { 2, 1, 3, null, null, null, 4 }))),
                new TestCase(makeTree(new Integer[] { 2, 1, 3 }), Set.of(makeTree(new Integer[] { 2, 1, 3 })))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.balanceBST(test.in);
            assert test.expected.contains(actual) : "balanceBST(%s) == %s, want any of %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        getValues(root, values);
        return makeBST(values, 0, values.size() - 1);
    }

    private static void getValues(TreeNode node, List<Integer> collector) {
        if (node == null) {
            return;
        }
        getValues(node.left, collector);
        collector.add(node.val);
        getValues(node.right, collector);
    }

    private static TreeNode makeBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = makeBST(values, start, mid - 1);
        TreeNode right = makeBST(values, mid + 1, end);
        return new TreeNode(values.get(mid), left, right);
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