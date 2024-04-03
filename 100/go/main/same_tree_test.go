package main

import (
	"strconv"
	"testing"
)

func TestIsSameTree(t *testing.T) {
	cases := []struct {
		in1  *TreeNode
		in2  *TreeNode
		want bool
	}{
		{makeTree([]string{"1", "2", "3"}), makeTree([]string{"1", "2", "3"}), true},
		{makeTree([]string{"1", "2"}), makeTree([]string{"1", "nil", "2"}), false},
		{makeTree([]string{"1", "2", "1"}), makeTree([]string{"1", "1", "2"}), false},
	}
	for _, c := range cases {
		got := IsSameTree(c.in1, c.in2)
		if got != c.want {
			t.Errorf("IsSameTree(%v, %v) == %v, want %v", c.in1, c.in2, got, c.want)
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
