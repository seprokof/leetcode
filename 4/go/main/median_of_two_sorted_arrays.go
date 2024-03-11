package main

func FindMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}
	len1, len2 := len(nums1), len(nums2)
	lenTotal := len1 + len2
	partitionSize := (lenTotal + 1) / 2

	nums1LeftPtr, nums1RightPtr := 0, len1
	for nums1LeftPtr <= nums1RightPtr {
		nums1MidPtr := (nums1LeftPtr + nums1RightPtr) / 2
		nums2MidPtr := partitionSize - nums1MidPtr

		nums1MidLeftVal, nums1MidRightVal := -1000001, 1000001
		nums2MidLeftVal, nums2MidRightVal := -1000001, 1000001

		if nums1MidPtr-1 >= 0 {
			nums1MidLeftVal = nums1[nums1MidPtr-1]
		}
		if nums1MidPtr < len1 {
			nums1MidRightVal = nums1[nums1MidPtr]
		}
		if nums2MidPtr-1 >= 0 {
			nums2MidLeftVal = nums2[nums2MidPtr-1]
		}
		if nums2MidPtr < len2 {
			nums2MidRightVal = nums2[nums2MidPtr]
		}

		if nums1MidLeftVal <= nums2MidRightVal && nums2MidLeftVal <= nums1MidRightVal {
			if lenTotal%2 == 0 {
				return float64(max(nums1MidLeftVal, nums2MidLeftVal)+min(nums1MidRightVal, nums2MidRightVal)) / 2
			} else {
				return float64(max(nums1MidLeftVal, nums2MidLeftVal))
			}
		} else if nums1MidLeftVal > nums2MidRightVal {
			nums1RightPtr = nums1MidPtr - 1
		} else {
			nums1LeftPtr = nums1MidPtr + 1
		}
	}
	return -1
}
