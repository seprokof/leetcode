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

func IsSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	} else if p != nil && q != nil {
		return p.Val == q.Val && IsSameTree(p.Left, q.Left) && IsSameTree(p.Right, q.Right)
	}
	return false
}
