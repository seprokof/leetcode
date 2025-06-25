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
	if len(values) < 1 {
		return nil
	}
	root := convertNode(values[0])
	if root == nil {
		return nil
	}
	prevLevel := []*TreeNode{root}
	index := 1
	for index < len(values) {
		currentLevel := make([]*TreeNode, 0, len(prevLevel)*2)
		for i := 0; i < len(prevLevel) && index < len(values); i++ {
			leftNode := convertNode(values[index])
			if leftNode != nil {
				prevLevel[i].Left = leftNode
				currentLevel = append(currentLevel, leftNode)
			}
			index++
			if index < len(values) {
				rightNode := convertNode(values[index])
				if rightNode != nil {
					prevLevel[i].Right = rightNode
					currentLevel = append(currentLevel, rightNode)
				}
				index++
			}
		}
		prevLevel = currentLevel
	}
	return root
}

func convertNode(value string) *TreeNode {
	intVal, err := strconv.Atoi(value)
	if err != nil {
		return nil
	}
	return &TreeNode{Val: intVal}
}
