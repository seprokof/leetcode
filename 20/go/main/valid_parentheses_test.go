package main

import "testing"

func TestIsValid(t *testing.T) {
	cases := []struct {
		in   string
		want bool
	}{
		{"()", true},
		{"()[]{}", true},
		{"(]", false},
	}
	for _, c := range cases {
		got := IsValid(c.in)
		if got != c.want {
			t.Errorf("IsValid('%v') == %t, want %t", c.in, got, c.want)
		}
	}
}
