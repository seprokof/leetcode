package main

func IsValid(s string) bool {
	pairs := make(map[rune]rune, 3)
	pairs['}'] = '{'
	pairs[')'] = '('
	pairs[']'] = '['
	stack := make([]rune, len(s))
	i := 0
	for _, char := range s {
		if char == '{' || char == '(' || char == '[' {
			stack[i] = char
			i++
		} else if i < 1 {
			return false
		} else if stack[i-1] != pairs[char] {
			return false
		} else {
			i--
		}
	}
	return i == 0
}
