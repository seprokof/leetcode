# 3212. Count Submatrices With Equal Frequency of X and Y
Given a 2D character matrix `grid`, where `grid[i][j]` is either `'X'`, `'Y'`, or `'.'`, return the number of submatrices (a submatrix `(x1, y1, x2, y2)` is a matrix that forms by choosing all cells `matrix[x][y]` where `x1 <= x <= x2` and `y1 <= y <= y2`) that contain:  
- `grid[0][0]`  
- an **equal** frequency of `'X'` and `'Y'`.  
- **at least** one `'X'`.  


**Example 1:**
```
Input: grid = [["X","Y","."],["Y",".","."]]
Output: 3
Explanation:
```
![Ooops](https://assets.leetcode.com/uploads/2024/01/01/example1.png)


**Example 2:**
```
Input: grid = [["X","X"],["X","Y"]]
Output: 0
Explanation:
No submatrix has an equal frequency of 'X' and 'Y'.
```

**Example 3:**
```
Input: grid = [[".","."],[".","."]]
Output: 0
Explanation:
No submatrix has at least one 'X'.
```

**Constraints:**
- `1 <= grid.length, grid[i].length <= 1000`
- `grid[i][j]` is either `'X'`, `'Y'`, or `'.'`.
