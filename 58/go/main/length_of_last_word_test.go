package main

import (
	"testing"
)

func TestLengthOfLastWord(t *testing.T) {
	cases := []struct {
		in   string
		want int
	}{
		{"Hello World", 5},
		{"   fly me   to   the moon  ", 4},
		{"luffy is still joyboy", 6},
	}
	for _, c := range cases {
		got := LengthOfLastWord(c.in)
		if got != c.want {
			t.Errorf("LengthOfLastWord(%v) == %v, want %v", c.in, got, c.want)
		}
	}
}
