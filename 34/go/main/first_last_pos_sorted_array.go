package main

func SearchRange(nums []int, target int) []int {
	result := []int{-1, -1}
	startIndex := binarySearch(nums, 0, target, true)
	if startIndex > -1 {
		result[0] = startIndex
		result[1] = max(startIndex, binarySearch(nums[startIndex+1:], startIndex+1, target, false))
	}
	return result
}

// Binary search over "part" slice.
// "startIndex" keeps index of first element of "part" slice within parent slice
// "target" is the value to find
// "leftBound" flag indicating if search should locate left or right bound
func binarySearch(part []int, startIndex int, target int, leftBound bool) int {
	if len(part) < 1 {
		return -1
	} else if len(part) == 1 && part[0] != target {
		return -1
	}
	midIndex := (len(part) - 1) / 2
	if part[midIndex] == target {
		if leftBound && midIndex > 0 && part[midIndex-1] == target {
			return binarySearch(part[:midIndex], startIndex, target, leftBound)
		} else if !leftBound && midIndex < len(part)-1 && part[midIndex+1] == target {
			return binarySearch(part[midIndex+1:], startIndex+midIndex+1, target, leftBound)
		}
		return startIndex + midIndex
	} else if part[midIndex] > target {
		return binarySearch(part[:midIndex], startIndex, target, leftBound)
	} else {
		return binarySearch(part[midIndex+1:], startIndex+midIndex+1, target, leftBound)
	}
}
