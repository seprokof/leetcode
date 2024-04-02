package main

func TrailingZeroes(n int) int {
	numZeroes := 0
	for n > 0 {
		n /= 5
		numZeroes += n
	}
	return numZeroes
}
