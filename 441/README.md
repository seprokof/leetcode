# 441. Arranging Coins
You have `n` coins and you want to build a staircase with these coins. The staircase consists of `k` rows where the `i`th row has exactly `i` coins. The last row of the staircase **may be** incomplete. Given the integer `n`, return *the number of* **complete rows** *of the staircase you will build*.

**Example 1:**

![Ooops](https://assets.leetcode.com/uploads/2021/04/09/arrangecoins1-grid.jpg)
```
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
```

**Example 2:**

![Ooops](https://assets.leetcode.com/uploads/2021/04/09/arrangecoins2-grid.jpg)
```
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
```

**Constraints:**
- `1 <= n <= 2^31 - 1`
