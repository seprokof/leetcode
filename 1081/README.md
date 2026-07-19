# 1081. Smallest Subsequence of Distinct Characters
Given a string `s`, *return the lexicographically smallest subsequence* (a string `a` is **lexicographically smaller** than a string `b` if in the first position where `a` and `b` differ, string `a` has a letter that appears earlier in the alphabet than the corresponding letter in `b`. If the first `min(a.length, b.length)` characters do not differ, then the shorter string is the lexicographically smaller one) *of* `s` *that contains all the distinct characters of* `s` *exactly once*.

**Example 1:**
```
Input: s = "bcabc"
Output: "abc"
```

**Example 2:**
```
Input: s = "cbacdcbc"
Output: "acdb"
```

**Constraints:**
- `1 <= s.length <= 1000`
- `s` consists of lowercase English letters.

**Note:** This question is the same as [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/).
