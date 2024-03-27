package main

func IsAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	letters := make(map[rune]int)
	for _, char := range s {
		letters[char]++
	}
	for _, char := range t {
		val, ok := letters[char]
		if !ok {
			return false
		} else if val == 1 {
			delete(letters, char)
		} else {
			letters[char]--
		}
	}
	return len(letters) == 0
}
