package main

import (
	"testing"
)

func TestReverseWords(t *testing.T) {
	cases := []struct {
		in   string
		want string
	}{
		{"the sky is blue", "blue is sky the"},
		{"  hello world  ", "world hello"},
		{"a good   example", "example good a"},
	}
	for _, c := range cases {
		got := ReverseWords(c.in)
		if got != c.want {
			t.Errorf("ReverseWords('%v') produced '%v', want '%v'", c.in, got, c.want)
		}
	}
}
