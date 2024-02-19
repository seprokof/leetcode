package main

func AddBinary(a string, b string) string {
	var shortStr, longStr string
	if len(a) > len(b) {
		shortStr = b
		longStr = a
	} else {
		shortStr = a
		longStr = b
	}
	mind := false
	result := make([]rune, len(longStr))
	for i, j := len(longStr)-1, len(shortStr)-1; i >= 0; i, j = i-1, j-1 {
		l, r := rune(longStr[i]), '0'
		if j >= 0 {
			r = rune(shortStr[j])
		}
		result[i], mind = addWithMind(l, r, mind)
	}
	if mind {
		result = append([]rune{'1'}, result...)
	}
	return string(result)
}

// Sums two binary digits respecting leftover overflow returning result and overflow flag
func addWithMind(a, b rune, mind bool) (rune, bool) {
	sum, m := add(a, b)
	if !mind {
		return sum, m
	}
	sum, m1 := add(sum, '1')
	return sum, m || m1
}

// Sums two binary digits returning result and overflow flag
func add(a, b rune) (rune, bool) {
	if a == b {
		return '0', a == '1'
	} else {
		return '1', false
	}
}
