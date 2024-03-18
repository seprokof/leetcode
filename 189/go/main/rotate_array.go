package main

import (
	"slices"
)

func Rotate(nums []int, k int) {
	rotate3(nums, k)
}

func rotate1(nums []int, k int) {
	k = k % len(nums)
	var temp int
	for j := 0; j < k; j++ {
		temp = nums[len(nums)-1]
		for i := len(nums) - 1; i > 0; i-- {
			nums[i] = nums[i-1]
		}
		nums[0] = temp
	}
}

func rotate2(nums []int, k int) {
	k = k % len(nums)
	right := make([]int, k)
	copy(right, nums[len(nums)-k:])
	for i := len(nums) - 1; i >= k; i-- {
		nums[i] = nums[i-k]
	}
	copy(nums, right)
}

func rotate3(nums []int, k int) {
	k = k % len(nums)
	slices.Reverse(nums)
	slices.Reverse(nums[:k])
	slices.Reverse(nums[k:])
}
