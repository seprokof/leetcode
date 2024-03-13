package main

import "math"

func Reverse(x int) int {
	var sum int
	for i, j := 1000000000, 1; i > 0; i = i / 10 {
		value := x / i * j
		if sum > 0 && ((math.MaxInt32-sum) < value) || sum < 0 && ((math.MinInt32-sum) > value) {
			return 0
		}
		sum += value
		if j > 1 || x%i != x {
			j = 10 * j
		}
		x = x % i
	}
	return sum
}
