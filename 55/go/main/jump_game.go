package main

func CanJump(nums []int) bool {
	maxIdx := 1
	for i := 1; i < len(nums); i++ {
		if i > maxIdx {
			return false
		}
		maxIdx = max(maxIdx, nums[i]+i)
	}
	return true
}
