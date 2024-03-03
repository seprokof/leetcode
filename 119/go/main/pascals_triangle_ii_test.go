package main

import (
	"testing"
)

func TestGetRow(t *testing.T) {
	cases := []struct {
		in   int
		want []int
	}{
		{3, []int{1, 3, 3, 1}},
		{0, []int{1}},
		{1, []int{1, 1}},
	}
	for _, c := range cases {
		got := GetRow(c.in)
		if !equal(got, c.want) {
			t.Errorf("GetRow(%v) produced %v, want %v", c.in, got, c.want)
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
