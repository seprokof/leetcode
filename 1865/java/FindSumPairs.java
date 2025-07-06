import java.util.HashMap;
import java.util.Map;

class FindSumPairs {

    private final int[] nums1;
    private final int[] nums2;
    private final Map<Integer, Integer> frequency;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.frequency = new HashMap<>();
        for (int n2 : nums2) {
            frequency.put(n2, frequency.getOrDefault(n2, 0) + 1);
        }
    }

    public void add(int index, int val) {
        Integer currentFreq = frequency.get(nums2[index]);
        if (currentFreq != null) {
            frequency.put(nums2[index], --currentFreq);
        }
        nums2[index] += val;
        frequency.put(nums2[index], frequency.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int result = 0;
        for (int n1 : nums1) {
            result += frequency.getOrDefault(tot - n1, 0);
        }
        return result;
    }

}
