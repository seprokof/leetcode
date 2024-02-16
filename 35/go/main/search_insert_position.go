package main

func SearchInsert(nums []int, target int) int {
	if len(nums) == 1 {
		if nums[0] >= target {
			return 0
		}
		return 1
	}
	i := len(nums) / 2
	if nums[i] == target {
		return i
	} else if nums[i] > target {
		return SearchInsert(nums[:i], target)
	} else {
		return SearchInsert(nums[i:], target) + i
	}
}
