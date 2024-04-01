package main

func ContainsNearbyDuplicate(nums []int, k int) bool {
	valueToIndex := make(map[int]int)
	for j := 0; j < len(nums); j++ {
		if i, ok := valueToIndex[nums[j]]; ok && j-i <= k {
			return true
		}
		valueToIndex[nums[j]] = j
	}
	return false
}
