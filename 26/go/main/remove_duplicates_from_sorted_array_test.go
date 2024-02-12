package main

import "testing"

func TestRemoveDuplicates(t *testing.T) {
	cases := []struct {
		in    []int
		want1 int
		want2 []int
	}{
		{[]int{1, 1, 2}, 2, []int{1, 2}},
		{[]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, []int{0, 1, 2, 3, 4}},
	}
	for _, c := range cases {
		inCopy := make([]int, len(c.in))
		copy(inCopy, c.in)
		got := RemoveDuplicates(c.in)
		gotSlice := c.in[:got]
		if got != c.want1 || !equal(gotSlice, c.want2) {
			t.Errorf("RemoveDuplicates(%v) == %v (slice %v), want %v (slice %v)", inCopy, got, gotSlice, c.want1, c.want2)
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
