package main

import (
	"slices"
	"testing"
)

func TestRemoveElement(t *testing.T) {
	cases := []struct {
		in1   []int
		in2   int
		want1 []int
		want2 int
	}{
		{[]int{3, 2, 2, 3}, 3, []int{2, 2}, 2},
		{[]int{0, 1, 2, 2, 3, 0, 4, 2}, 2, []int{0, 1, 4, 0, 3}, 5},
	}
	for _, c := range cases {
		inCopy := make([]int, len(c.in1))
		copy(inCopy, c.in1)
		got := RemoveElement(c.in1, c.in2)
		gotSlice := c.in1[:got]
		if got != c.want2 || !equal(gotSlice, c.want1) {
			t.Errorf("RemoveElement(%v, %v) == %v (slice %v), want %v (slice %v)", inCopy, c.in2, got, gotSlice, c.want2, c.want1)
		}
	}
}

// Checks slices are equal
func equal(left, right []int) bool {
	if len(left) != len(right) {
		return false
	}
	slices.Sort(left)
	slices.Sort(right)
	for i := 0; i < len(left); i++ {
		if left[i] != right[i] {
			return false
		}
	}
	return true
}
