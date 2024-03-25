package main

import (
	"testing"
)

func TestCanConstruct(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want bool
	}{
		{"a", "b", false},
		{"aa", "ab", false},
		{"aa", "aab", true},
	}
	for _, c := range cases {
		got := CanConstruct(c.in1, c.in2)
		if got != c.want {
			t.Errorf("CanConstruct(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
