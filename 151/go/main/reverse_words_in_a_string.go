package main

import (
	"strings"
)

func ReverseWords(s string) string {
	startIndex := len(s)
	var line strings.Builder
	for i := len(s) - 1; i >= 0; i-- {
		char := rune(s[i])
		if char == ' ' {
			if startIndex < len(s) {
				appendWord(&line, s[i+1:startIndex+1])
				startIndex = len(s)
			}
		} else {
			if i == 0 {
				if startIndex < len(s) {
					appendWord(&line, s[:startIndex+1])
				} else {
					appendWord(&line, string(s[i]))
				}
			} else if startIndex == len(s) {
				startIndex = i
			}
		}
	}
	return line.String()
}

func appendWord(line *strings.Builder, word string) {
	if line.Len() > 0 {
		line.WriteRune(' ')
	}
	line.WriteString(word)
}
