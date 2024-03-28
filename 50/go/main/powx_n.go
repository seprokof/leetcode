package main

func MyPow(x float64, n int) float64 {
	if n == 0 || x == 1 {
		return 1
	}
	result := 1.0
	if n < 0 {
		n = -n
		x = 1 / x
	}
	for n > 0 {
		if n%2 != 0 {
			result *= x
		}
		x *= x
		n /= 2
	}
	return result
}
