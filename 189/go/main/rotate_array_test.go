package main

import (
	"testing"
)

func TestRotate(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want []int
	}{
		{[]int{1, 2, 3, 4, 5, 6, 7}, 3, []int{5, 6, 7, 1, 2, 3, 4}},
		{[]int{-1, -100, 3, 99}, 2, []int{3, 99, -1, -100}},
	}
	for _, c := range cases {
		in1Copy := make([]int, len(c.in1))
		copy(in1Copy, c.in1)
		Rotate(c.in1, c.in2)
		if !equal(c.in1, c.want) {
			t.Errorf("Rotate(%v, %v) produced %v, want %v", in1Copy, c.in2, c.in1, c.want)
		}
	}
}

// Checks if two slices contain the same values
func equal(left, right []int) bool {
	if len(left) != len(right) {
		return false
	}
	for i := 0; i < len(left); i++ {
		if left[i] != right[i] {
			return false
		}
	}
	return true
}
