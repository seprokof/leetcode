package main

import (
	"strconv"
	"testing"
)

func TestInorderTraversal(t *testing.T) {
	cases := []struct {
		in   *TreeNode
		want []int
	}{
		{makeTree([]string{"1", "nil", "2", "3"}), []int{1, 3, 2}},
		{makeTree([]string{}), []int{}},
		{makeTree([]string{"1"}), []int{1}},
	}
	for _, c := range cases {
		got := InorderTraversal(c.in)
		if !equal(got, c.want) {
			t.Errorf("InorderTraversal(%v) == %v, want %v", c.in, got, c.want)
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

// Checks if two slices contain the same values
func equal(left, right []int) bool {
	if len(left) != len(right) {
		return false
	}
	for i := 0; i < len(left); i++ {
		if left[i] != right[i] {
			return false
		}
	}
	return true
}
