package main

import (
	"testing"
)

func TestTrailingZeroes(t *testing.T) {
	cases := []struct {
		in   int
		want int
	}{
		{3, 0},
		{5, 1},
		{0, 0},
	}
	for _, c := range cases {
		got := TrailingZeroes(c.in)
		if got != c.want {
			t.Errorf("TrailingZeroes(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
