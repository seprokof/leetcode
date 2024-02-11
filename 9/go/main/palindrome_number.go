package main

func IsPalindrome(x int) bool {
	l, r := x, 0
	for l > 0 {
		l, r = l/10, (r*10)+l%10
	}
	return r == x
}
