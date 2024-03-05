package main

import (
	"testing"
)

func TestSingleNumber(t *testing.T) {
	cases := []struct {
		in   []int
		want int
	}{
		{[]int{2, 2, 1}, 1},
		{[]int{4, 1, 2, 1, 2}, 4},
		{[]int{1}, 1},
	}
	for _, c := range cases {
		got := SingleNumber(c.in)
		if got != c.want {
			t.Errorf("SingleNumber(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
