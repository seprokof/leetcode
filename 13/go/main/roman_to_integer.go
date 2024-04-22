package main

func RomanToInt(s string) int {
	table := map[byte]int{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
	result := 0
	previousValue := 0
	for i := len(s) - 1; i >= 0; i-- {
		currentValue := table[s[i]]
		if currentValue >= previousValue {
			result += currentValue
		} else {
			result -= currentValue
		}
		previousValue = currentValue
	}
	return result
}
