package main

import (
	"math"
	"testing"
)

func TestMyPow(t *testing.T) {
	cases := []struct {
		in1  float64
		in2  int
		want float64
	}{
		{2.00000, 10, 1024.00000},
		{2.10000, 3, 9.26100},
		{2.00000, -2, 0.25000},
	}
	for _, c := range cases {
		got := math.Round(MyPow(c.in1, c.in2)*100000) / 100000
		if got != c.want {
			t.Errorf("MyPow(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
