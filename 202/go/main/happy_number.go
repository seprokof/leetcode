package main

func IsHappy(n int) bool {
	seen := make(map[int]int)
	for {
		newValue := summSquaresDigits(n)
		if newValue == 1 {
			return true
		} else if _, ok := seen[newValue]; ok {
			return false
		} else {
			seen[newValue]++
			n = newValue
		}
	}
}

// Returns sum of the squares of digits of given number
func summSquaresDigits(n int) int {
	if n < 10 {
		return n * n
	}
	lastDigit := n % 10
	return summSquaresDigits(n/10) + lastDigit*lastDigit
}
