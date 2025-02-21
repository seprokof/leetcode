# 482. License Key Formatting
You are given a license key represented as a string `s` that consists of only alphanumeric characters and dashes. The string is separated into `n + 1` groups by n dashes. You are also given an integer `k`. We want to reformat the string `s` such that each group contains exactly `k` characters, except for the first group, which could be shorter than `k` but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase. Return *the reformatted license key*.

**Example 1:**
```
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
```

**Example 2:**
```
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
```

**Constraints:**
- `1 <= num < 2^31`

**Note:** This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
