import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0, 4),
                new TestCase(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3, -1),
                new TestCase(new int[] { 1 }, 0, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.search(test.in1, test.in2);
            assert test.expected == actual : "search(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int midIdx = (left + right) / 2;
        if (arr[midIdx] == target) {
            return midIdx;
        } else if (arr[left] <= arr[midIdx]) {
            if (arr[left] <= target && target < arr[midIdx]) {
                return binarySearch(arr, target, left, midIdx - 1);
            } else {
                return binarySearch(arr, target, midIdx + 1, right);
            }
        } else {
            if (arr[midIdx] < target && target <= arr[right]) {
                return binarySearch(arr, target, midIdx + 1, right);
            } else {
                return binarySearch(arr, target, left, midIdx - 1);
            }
        }
    }

}