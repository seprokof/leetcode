package main

import (
	"strconv"
	"testing"
)

func TestLevelOrder(t *testing.T) {
	cases := []struct {
		in   *TreeNode
		want [][]int
	}{
		{makeTree([]string{"3", "9", "20", "nil", "nil", "15", "7"}), [][]int{{3}, {9, 20}, {15, 7}}},
		{makeTree([]string{"1"}), [][]int{{1}}},
		{makeTree([]string{}), [][]int{}},
	}
	for _, c := range cases {
		got := LevelOrder(c.in)
		if !equal(got, c.want) {
			t.Errorf("LevelOrder(%v) == %v, want %v", c.in, got, c.want)
		}
	}
}

// Creates binary tree from given level order traversal of its nodes values returning root of the tree.
func makeTree(values []string) *TreeNode {
	return makeSubTree(values, 0)
}

func makeSubTree(values []string, nodeIndex int) *TreeNode {
	if nodeIndex >= len(values) {
		return nil
	}
	strVal, err := strconv.Atoi(values[nodeIndex])
	if err != nil {
		return nil
	}
	return &TreeNode{Val: strVal, Left: makeSubTree(values, 2*nodeIndex+1), Right: makeSubTree(values, 2*nodeIndex+2)}
}

func equal(left, right [][]int) bool {
	if len(left) != len(right) {
		return false
	}
	for i := 0; i < len(left); i++ {
		if len(left[i]) != len(right[i]) {
			return false
		}
		for j := 0; j < len(left[i]); j++ {
			if left[i][j] != right[i][j] {
				return false
			}
		}
	}
	return true
}
