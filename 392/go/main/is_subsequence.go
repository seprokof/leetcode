package main

import (
	"strings"
)

func IsSubsequence(s string, t string) bool {
	if len(s) == 0 {
		return true
	}
	if len(t) == 0 {
		return false
	}
	if len(s) > len(t) {
		return false
	}
	start := 0
	for _, char := range s {
		index := strings.IndexRune(t[start:], char)
		if index < 0 {
			return false
		} else {
			start = start + index + 1
		}
	}
	return true
}
