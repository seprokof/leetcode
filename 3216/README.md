# 3216. Lexicographically Smallest String After a Swap
Given a string `s` containing only digits, return the lexicographically smallest string (a string `a` is **lexicographically smaller** than a string `b` if in the first position where `a` and `b` differ, string `a` has a letter that appears earlier in the alphabet than the corresponding letter in `b`. If the first `min(a.length, b.length)` characters do not differ, then the shorter string is the lexicographically smaller one) that can be obtained after swapping **adjacent** digits in `s` with the same **parity** at most **once**.

Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.

**Example 1:**
```
Input: s = "45320"
Output: "43520"
Explanation:
s[1] == '5' and s[2] == '3' both have the same parity, and swapping them results in the lexicographically smallest string.
```

**Example 2:**
```
Input: s = "001"
Output: "001"
Explanation:
There is no need to perform a swap because s is already the lexicographically smallest.
```

**Constraints:**
- `2 <= s.length <= 100`
- `s` consists only of digits.
