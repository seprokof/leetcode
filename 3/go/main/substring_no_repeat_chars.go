package main

func LengthOfLongestSubstring(s string) int {
	set := make(map[rune]int, len(s))
	leftBound, maxSubstr := 0, 0
	for pos, char := range s {
		prev, ok := set[char]
		if ok && leftBound < prev+1 {
			leftBound = prev + 1
		}
		set[char] = pos
		maxSubstr = max(maxSubstr, pos-leftBound+1)
	}
	return maxSubstr
}
