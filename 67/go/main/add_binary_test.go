package main

import (
	"testing"
)

func TestAddBinary(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want string
	}{
		{"11", "1", "100"},
		{"1010", "1011", "10101"},
	}
	for _, c := range cases {
		got := AddBinary(c.in1, c.in2)
		if got != c.want {
			t.Errorf("AddBinary(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
