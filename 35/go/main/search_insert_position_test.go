package main

import (
	"testing"
)

func TestSearchInsert(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want int
	}{
		{[]int{1, 3, 5, 6}, 5, 2},
		{[]int{1, 3, 5, 6}, 2, 1},
		{[]int{1, 3, 5, 6}, 7, 4},
	}
	for _, c := range cases {
		got := SearchInsert(c.in1, c.in2)
		if got != c.want {
			t.Errorf("SearchInsert(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
