package main

import (
	"testing"
)

func TestLongestPalindrome(t *testing.T) {
	cases := []struct {
		in   string
		want string
	}{
		{"babad", "bab"},
		{"cbbd", "bb"},
	}
	for _, c := range cases {
		got := LongestPalindrome(c.in)
		if got != c.want {
			t.Errorf("LongestPalindrome(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
