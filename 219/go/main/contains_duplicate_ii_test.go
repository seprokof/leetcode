package main

import (
	"testing"
)

func TestContainsNearbyDuplicate(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want bool
	}{
		{[]int{1, 2, 3, 1}, 3, true},
		{[]int{1, 0, 1, 1}, 1, true},
		{[]int{1, 2, 3, 1, 2, 3}, 2, false},
	}
	for _, c := range cases {
		got := ContainsNearbyDuplicate(c.in1, c.in2)
		if got != c.want {
			t.Errorf("ContainsNearbyDuplicate(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
