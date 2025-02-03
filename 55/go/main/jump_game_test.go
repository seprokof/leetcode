package main

import (
	"testing"
)

func TestCanJump(t *testing.T) {
	cases := []struct {
		in   []int
		want bool
	}{
		{[]int{2, 3, 1, 1, 4}, true},
		{[]int{3, 2, 1, 0, 4}, false},
	}
	for _, c := range cases {
		got := CanJump(c.in)
		if got != c.want {
			t.Errorf("CanJump(%v) == %v, want %v", c.in, got, c.want)
		}
	}
}
