package main

import "strings"

func WordPattern(pattern string, s string) bool {
	words := strings.Split(s, " ")
	if len(pattern) != len(words) {
		return false
	}
	direct := make(map[rune]string)
	inverse := make(map[string]rune)
	for pos, char := range pattern {
		if val, ok := direct[char]; ok && val != words[pos] {
			return false
		}
		if val, ok := inverse[words[pos]]; ok && val != char {
			return false
		}
		direct[char] = words[pos]
		inverse[words[pos]] = char
	}
	return true
}
