package main

func LongestCommonPrefix(strs []string) string {
	var i int
	for pos, char := range strs[0] {
		for _, s := range strs[1:] {
			if len(s) <= pos || rune(s[pos]) != char {
				return strs[0][:i]
			}
		}
		i++
	}
	return strs[0][:i]
}
