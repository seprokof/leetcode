package main

func CanConstruct(ransomNote string, magazine string) bool {
	chars := make(map[rune]int)
	for _, char := range magazine {
		chars[char]++
	}
	for _, char := range ransomNote {
		chars[char]--
		if chars[char] < 0 {
			return false
		}
	}
	return true
}
