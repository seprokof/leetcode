package main

import (
	"unicode"
)

func IsPalindrome(s string) bool {
	for i, j := 0, len(s)-1; i < j; {
		leftRune, rightRune := rune(s[i]), rune(s[j])
		isLeftAlphanumeric := isAlphanumeric(leftRune)
		if isLeftAlphanumeric && isAlphanumeric(rightRune) {
			if unicode.ToLower(leftRune) != unicode.ToLower(rightRune) {
				return false
			}
			i, j = i+1, j-1
		} else if isLeftAlphanumeric {
			j--
		} else {
			i++
		}
	}
	return true
}

func isAlphanumeric(l rune) bool {
	return unicode.IsLetter(l) || unicode.IsDigit(l)
}
