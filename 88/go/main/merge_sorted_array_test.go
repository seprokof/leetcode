package main

import (
	"testing"
)

func TestMerge(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		in3  []int
		in4  int
		want []int
	}{
		{[]int{1, 2, 3, 0, 0, 0}, 3, []int{2, 5, 6}, 3, []int{1, 2, 2, 3, 5, 6}},
		{[]int{1}, 1, []int{}, 0, []int{1}},
		{[]int{0}, 0, []int{1}, 1, []int{1}},
	}
	for _, c := range cases {
		inCopy := make([]int, len(c.in1))
		copy(inCopy, c.in1)
		Merge(c.in1, c.in2, c.in3, c.in4)
		if !equal(c.in1, c.want) {
			t.Errorf("Merge(%v, %v, %v, %v) produced %v, want %v", inCopy, c.in2, c.in3, c.in4, c.in1, c.want)
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
