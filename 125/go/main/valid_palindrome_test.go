package main

import (
	"testing"
)

func TestIsPalindrome(t *testing.T) {
	cases := []struct {
		in   string
		want bool
	}{
		{"A man, a plan, a canal: Panama", true},
		{"race a car", false},
		{" ", true},
		{"0P", false},
	}
	for _, c := range cases {
		got := IsPalindrome(c.in)
		if got != c.want {
			t.Errorf("IsPalindrome(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
