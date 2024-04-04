package main

import (
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (t *TreeNode) String() string {
	var builder strings.Builder
	builder.WriteString("[")
	if t == nil {
		builder.WriteString("nil")
	} else {
		visit := []*TreeNode{t}
		result := []string{}
		for len(visit) > 0 {
			currentNode := visit[0]
			visit = visit[1:]
			if currentNode != nil {
				result = append(result, strconv.Itoa(currentNode.Val))
				if currentNode.Left != nil || currentNode.Right != nil {
					visit = append(visit, currentNode.Left)
					visit = append(visit, currentNode.Right)
				}
			} else {
				result = append(result, "nil")
			}
		}
		builder.WriteString(strings.Join(result, ", "))
	}
	builder.WriteString("]")
	return builder.String()
}

func LevelOrder(root *TreeNode) [][]int {
	visit := []*TreeNode{root}
	result := [][]int{}
	for len(visit) > 0 {
		numNodesCurrentLevel := len(visit)
		var subResult []int
		for i := 0; i < numNodesCurrentLevel; i++ {
			node := visit[i]
			if node != nil {
				subResult = append(subResult, node.Val)
				if node.Left != nil {
					visit = append(visit, node.Left)
				}
				if node.Right != nil {
					visit = append(visit, node.Right)
				}
			}
		}
		visit = visit[numNodesCurrentLevel:]
		if subResult != nil {
			result = append(result, subResult)
		}
	}
	return result
}
