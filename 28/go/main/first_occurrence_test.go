package main

import (
	"testing"
)

func TestStrStr(t *testing.T) {
	cases := []struct {
		in1  string
		in2  string
		want int
	}{
		{"sadbutsad", "sad", 0},
		{"leetcode", "leeto", -1},
	}
	for _, c := range cases {
		got := StrStr(c.in1, c.in2)
		if got != c.want {
			t.Errorf("StrStr(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}
