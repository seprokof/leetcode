package main

import (
	"strconv"
	"testing"
)

func TestIsSymmetric(t *testing.T) {
	cases := []struct {
		in   *TreeNode
		want bool
	}{
		{makeTree([]string{"1", "2", "2", "3", "4", "4", "3"}), true},
		{makeTree([]string{"1", "2", "2", "nil", "3", "nil", "3"}), false},
	}
	for _, c := range cases {
		got := IsSymmetric(c.in)
		if got != c.want {
			t.Errorf("IsSymmetric(%v) == %v, want %v", c.in, got, c.want)
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
		for i := 0; i < len(prevLevel); i++ {
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
