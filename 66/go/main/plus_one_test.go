package main

import (
	"testing"
)

func TestPlusOne(t *testing.T) {
	cases := []struct {
		in   []int
		want []int
	}{
		{[]int{1, 2, 3}, []int{1, 2, 4}},
		{[]int{4, 3, 2, 1}, []int{4, 3, 2, 2}},
		{[]int{9}, []int{1, 0}},
	}
	for _, c := range cases {
		inCopy := make([]int, len(c.in))
		copy(inCopy, c.in)
		got := PlusOne(c.in)
		if !equal(got, c.want) {
			t.Errorf("PlusOne(%v) == %v, want %v", inCopy, got, c.want)
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
