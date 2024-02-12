package main

import "testing"

func TestTwoSum(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
		{[]int{3, 3}, 6, []int{0, 1}},
	}
	for _, c := range cases {
		got := TwoSum(c.in1, c.in2)
		if !equal(got, c.want) {
			t.Errorf("TwoSum(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}

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
