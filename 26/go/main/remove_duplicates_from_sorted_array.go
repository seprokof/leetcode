package main

func RemoveDuplicates(nums []int) int {
	k, i := 1, 1
	for ; i < len(nums); i++ {
		if nums[i-1] < nums[i] {
			nums[k] = nums[i]
			k++
		}
	}
	return k
}
