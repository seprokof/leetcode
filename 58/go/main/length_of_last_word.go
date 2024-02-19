package main

func LengthOfLastWord(s string) int {
	start := -1
	for i := len(s) - 1; i >= 0; i-- {
		if start == -1 && s[i] != ' ' {
			start = i
		} else if start != -1 && s[i] == ' ' {
			return start - i
		}
	}
	return start + 1
}
