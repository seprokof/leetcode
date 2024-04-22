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

func IsSymmetric(root *TreeNode) bool {
	return isSymmetric1(root.Left, root.Right)
	// return isSymmetric2(root)
}

// Recursive solution
func isSymmetric1(t1, t2 *TreeNode) bool {
	if t1 != nil && t2 != nil {
		return t1.Val == t2.Val && isSymmetric1(t1.Left, t2.Right) && isSymmetric1(t1.Right, t2.Left)
	}
	return t1 == nil && t2 == nil
}

// Iterative solution
func isSymmetric2(root *TreeNode) bool {
	q1, q2 := []*TreeNode{root.Left}, []*TreeNode{root.Right}
	for len(q1) > 0 || len(q2) > 0 {
		n1 := q1[0]
		q1 = q1[1:]
		n2 := q2[0]
		q2 = q2[1:]
		if n1 == nil && n2 == nil {
			continue
		} else if n1 != nil && n2 != nil {
			if n1.Val != n2.Val {
				return false
			}
			q1 = append(q1, n1.Left)
			q2 = append(q2, n2.Right)
			q1 = append(q1, n1.Right)
			q2 = append(q2, n2.Left)
		} else {
			return false
		}
	}
	return len(q1) == len(q2)
}
