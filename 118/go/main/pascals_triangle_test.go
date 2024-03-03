package main

import (
	"testing"
)

func TestGenerate(t *testing.T) {
	cases := []struct {
		in   int
		want [][]int
	}{
		{5, [][]int{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}}},
		{1, [][]int{{1}}},
	}
	for _, c := range cases {
		got := Generate(c.in)
		if !equal(got, c.want) {
			t.Errorf("Generate(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}

// Checks if two slices contain the same values
func equal(left, right [][]int) bool {
	if len(left) != len(right) {
		return false
	}
	for i := 0; i < len(left); i++ {
		if len(left[i]) != len(right[i]) {
			return false
		}
		for j := 0; j < len(left[i]); j++ {
			if left[i][j] != right[i][j] {
				return false
			}
		}
	}
	return true
}
