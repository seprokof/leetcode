package main

func GetRow(rowIndex int) []int {
	result := make([]int, rowIndex+1)
	result[0], result[rowIndex] = 1, 1
	for i := 1; i < rowIndex; i++ {
		result[i] = result[i-1] * (rowIndex - i + 1) / i
	}
	return result
}
