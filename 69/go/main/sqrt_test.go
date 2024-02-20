package main

import (
	"testing"
)

func TestMySqrt(t *testing.T) {
	cases := []struct {
		in   int
		want int
	}{
		{4, 2},
		{8, 2},
	}
	for _, c := range cases {
		got := MySqrt(c.in)
		if got != c.want {
			t.Errorf("MySqrt(%v) == %v, want %v", c.in, got, c.want)
		}
	}
}
