package main

import "slices"

func RemoveElement(nums []int, val int) int {
	slices.Sort(nums)
	posStart, _ := slices.BinarySearch(nums, val)
	var i int
	for i = 0; i+posStart < len(nums) && nums[i+posStart] == val; i++ {
		nums[i+posStart] = nums[len(nums)-1-i]
	}
	return len(nums) - i
}
