package main

import (
	"testing"
)

func TestMajorityElement(t *testing.T) {
	cases := []struct {
		in   []int
		want int
	}{
		{[]int{3, 2, 3}, 3},
		{[]int{2, 2, 1, 1, 1, 2, 2}, 2},
	}
	for _, c := range cases {
		got := MajorityElement(c.in)
		if got != c.want {
			t.Errorf("MajorityElement(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
