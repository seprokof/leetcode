package main

import (
	"testing"
)

func TestReverse(t *testing.T) {
	cases := []struct {
		in   int
		want int
	}{
		{123, 321},
		{-123, -321},
		{120, 21},
	}
	for _, c := range cases {
		got := Reverse(c.in)
		if got != c.want {
			t.Errorf("Reverse(%v) produced %v, want %v", c.in, got, c.want)
		}
	}
}
