package main

import (
	"testing"
)

func TestSearchRange(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want []int
	}{
		{[]int{5, 7, 7, 8, 8, 10}, 8, []int{3, 4}},
		{[]int{5, 7, 7, 8, 8, 10}, 6, []int{-1, -1}},
		{[]int{}, 0, []int{-1, -1}},
	}
	for _, c := range cases {
		got := SearchRange(c.in1, c.in2)
		if !equal(got, c.want) {
			t.Errorf("SearchRange(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}

// Checks slices are equal
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
