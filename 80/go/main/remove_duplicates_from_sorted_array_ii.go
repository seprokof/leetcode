package main

func RemoveDuplicates(nums []int) int {
	i := 1
	for j := 1; j < len(nums); j++ {
		if i == 1 || nums[j] != nums[i-2] {
			nums[i] = nums[j]
			i++
		}
	}
	return i
}
