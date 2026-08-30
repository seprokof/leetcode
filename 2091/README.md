# 2091. Removing Minimum and Maximum From Array
You are given a **0-indexed** array of **distinct** integers `nums`.  

There is an element in `nums` that has the **lowest** value and an element that has the **highest** value. We call them the **minimum** and **maximum** respectively. Your goal is to remove **both** these elements from the array.  

A **deletion** is defined as either removing an element from the **front** of the array or removing an element from the **back** of the array.

Return *the* **minimum** *number of deletions it would take to remove* **both** *the minimum and maximum element from the array*.

**Example 1:**
```
Input: s = "iiii", k = 1
Output: 36
Explanation:
The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.
```

**Example 2:**
```
Input: s = "leetcode", k = 2
Output: 6
Explanation:
The operations are as follows:
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- Transform #2: 33 ➝ 3 + 3 ➝ 6
Thus the resulting integer is 6.
```

**Example 3:**
```
Input: s = "zbax", k = 2
Output: 8
```

**Constraints:**
- `1 <= s.length <= 100`  
- `1 <= k <= 10`  
- `s` consists of lowercase English letters.  
