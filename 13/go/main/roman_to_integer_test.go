package main

import "testing"

func TestRomanToInt(t *testing.T) {
	cases := []struct {
		in   string
		want int
	}{
		{"III", 3},
		{"LVIII", 58},
		{"MCMXCIV", 1994},
	}
	for _, c := range cases {
		got := RomanToInt(c.in)
		if got != c.want {
			t.Errorf("RomanToInt(%v) == %v, want %v", c.in, got, c.want)
		}
	}
}
