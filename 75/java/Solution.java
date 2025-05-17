import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 0, 2, 1, 1, 0 }, new int[] { 0, 0, 1, 1, 2, 2 }),
                new TestCase(new int[] { 2, 0, 1 }, new int[] { 0, 1, 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] copy = Arrays.copyOf(test.in, test.in.length);
            s.sortColors(test.in);
            assert Arrays.equals(test.in, test.expected) : "sortColors(%s) -> %s, want %s"
                    .formatted(Arrays.toString(copy), Arrays.toString(test.in), Arrays.toString(test.expected));
        }
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}