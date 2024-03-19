package main

func IsIsomorphic(s string, t string) bool {
	direct := make(map[rune]rune)
	inverse := make(map[rune]rune)
	for i := 0; i < len(s); i++ {
		val, ok := direct[rune(s[i])]
		if !ok {
			direct[rune(s[i])] = rune(t[i])
		} else if val != rune(t[i]) {
			return false
		}
		val, ok = inverse[rune(t[i])]
		if !ok {
			inverse[rune(t[i])] = rune(s[i])
		} else if val != rune(s[i]) {
			return false
		}
	}
	return true
}
