package main

func LongestPalindrome(s string) string {
	return longestPalindromeManacher(s)
}

func longestPalindrome(s string) string {
	for i := len(s); i > 1; i-- {
		for j := 0; j+i <= len(s); j++ {
			if isPalindrom(s[j : j+i]) {
				return s[j : j+i]
			}
		}
	}
	return string(s[0])
}

func isPalindrom(s string) bool {
	l := len(s)
	for i := 0; i < l/2; i++ {
		if s[i] != s[l-1-i] {
			return false
		}
	}
	return true
}

// I'm not that smart...
// https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9C%D0%B0%D0%BD%D0%B0%D0%BA%D0%B5%D1%80%D0%B0
func longestPalindromeManacher(s string) string {
	p := make([]int, len(s)*2+1)
	p[0] = 0
	p[1] = 1
	c, r, index, iMir, maxLen := 1, 2, 0, 0, 1
	for i := 2; i < len(p); i++ {
		iMir = 2*c - i
		if r > i {
			p[i] = min(p[iMir], r-i)
		} else {
			p[i] = 0
		}
		for (i+p[i]+1) < len(p) && i > p[i] && (((i+p[i]+1)%2 == 0) || (s[(i+p[i]+1)/2] == s[(i-p[i]-1)/2])) {
			p[i]++
		}
		if p[i] > maxLen {
			maxLen = p[i]
			index = i
		}
		if p[i]+i > r {
			c = i
			r = i + p[i]
		}
	}
	start := (index - maxLen) / 2
	return s[start : start+maxLen]
}
