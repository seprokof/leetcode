package main

import (
	"testing"
)

func TestIsHappy(t *testing.T) {
	cases := []struct {
		in   int
		want bool
	}{
		{19, true},
		{2, false},
	}
	for _, c := range cases {
		got := IsHappy(c.in)
		if got != c.want {
			t.Errorf("IsHappy(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
