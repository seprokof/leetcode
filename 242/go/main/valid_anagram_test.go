package main

import (
	"testing"
)

func TestIsAnagram(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want bool
	}{
		{"anagram", "nagaram", true},
		{"rat", "car", false},
	}
	for _, c := range cases {
		got := IsAnagram(c.in1, c.in2)
		if got != c.want {
			t.Errorf("IsAnagram(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
