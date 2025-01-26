import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, TreeNode expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -10, -3, 0, 5, 9 }, makeTree(new Integer[] { 0, -3, 9, -10, null, 5 })),
                new TestCase(new int[] { 1, 3 }, makeTree(new Integer[] { 3, 1 }))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            TreeNode actual = s.sortedArrayToBST(test.in);
            assert Objects.equals(test.expected, actual) : "sortedArrayToBST(%s) == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = sortedArrayToBST(nums, left, mid);
        midNode.right = sortedArrayToBST(nums, mid + 1, right);
        return midNode;
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