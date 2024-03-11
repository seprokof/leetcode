package main

import (
	"testing"
)

func TestFindMedianSortedArrays(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  []int
		want float64
	}{
		{[]int{1, 3}, []int{2}, 2.0},
		{[]int{1, 2}, []int{3, 4}, 2.5},
	}
	for _, c := range cases {
		got := FindMedianSortedArrays(c.in1, c.in2)
		if got != c.want {
			t.Errorf("FindMedianSortedArrays(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
