package main

import (
	"testing"
)

func TestIsIsomorphic(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want bool
	}{
		{"egg", "add", true},
		{"foo", "bar", false},
		{"paper", "title", true},
	}
	for _, c := range cases {
		got := IsIsomorphic(c.in1, c.in2)
		if got != c.want {
			t.Errorf("IsIsomorphic(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
