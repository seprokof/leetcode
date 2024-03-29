package main

import (
	"testing"
)

func TestWordPattern(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want bool
	}{
		{"abba", "dog cat cat dog", true},
		{"abba", "dog cat cat fish", false},
		{"aaaa", "dog cat cat dog", false},
	}
	for _, c := range cases {
		got := WordPattern(c.in1, c.in2)
		if got != c.want {
			t.Errorf("WordPattern('%v', '%v') produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
