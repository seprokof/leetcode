package main

func MajorityElement(nums []int) int {
	return majorityElement(nums)
}

func majorityElement(nums []int) int {
	m := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		m[nums[i]]++
		if m[nums[i]] > len(nums)/2 {
			return nums[i]
		}
	}
	panic("Input doesn't contain majority element")
}

// https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
func majorityElementBoyerMoore(nums []int) int {
	var majorityElement, counter int
	for i := 0; i < len(nums); i++ {
		if counter == 0 {
			majorityElement = nums[i]
			counter++
		} else if majorityElement == nums[i] {
			counter++
		} else {
			counter--
		}
	}
	return majorityElement
}
