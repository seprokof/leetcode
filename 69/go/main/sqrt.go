package main

import "math"

// Solution is based on approach suggested in https://go.dev/tour/flowcontrol/8
func MySqrt(x int) int {
	if x < 2 {
		return x
	}
	z1, z2 := 1, 0
	for math.Abs(float64(z1-z2)) > 0.9 {
		z2 = z1
		z1 -= (z1*z1 - x) / (2 * z1)
	}
	if z1*z1 > x {
		z1--
	}
	return z1
}
