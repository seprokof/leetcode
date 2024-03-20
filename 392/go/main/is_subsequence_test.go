package main

import (
	"testing"
)

func TestIsSubsequence(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want bool
	}{
		{"abc", "ahbgdc", true},
		{"axc", "ahbgdc", false},
	}
	for _, c := range cases {
		got := IsSubsequence(c.in1, c.in2)
		if got != c.want {
			t.Errorf("IsSubsequence(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
