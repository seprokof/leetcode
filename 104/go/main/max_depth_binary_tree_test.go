package main

import (
	"strconv"
	"testing"
)

func TestMaxDepth(t *testing.T) {
	cases := []struct {
		in   *TreeNode
		want int
	}{
		{makeTree([]string{"3", "9", "20", "nil", "nil", "15", "7"}), 3},
		{makeTree([]string{"1", "nil", "2"}), 2},
	}
	for _, c := range cases {
		got := MaxDepth(c.in)
		if got != c.want {
			t.Errorf("MaxDepth(%v) == %v, want %v", c.in, got, c.want)
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
