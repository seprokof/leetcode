package main

func TwoSum(nums []int, target int) []int {
	valueToIndex := make(map[int]int)
	for i, v := range nums {
		index, ok := valueToIndex[target-v]
		if ok {
			return []int{index, i}
		} else {
			valueToIndex[v] = i
		}
	}
	return nil
}
