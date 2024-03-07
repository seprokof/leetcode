package main

import (
	"strconv"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l *ListNode) String() string {
	var builder strings.Builder
	builder.WriteString("[")
	for ; l != nil; l = l.Next {
		builder.WriteString(strconv.Itoa(l.Val))
		if l.Next != nil {
			builder.WriteString(", ")
		}
	}
	builder.WriteString("]")
	return builder.String()
}

func AddTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	mind := 0
	var head, current *ListNode
	for l1 != nil || l2 != nil || mind > 0 {
		sum := mind
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		mind = sum / 10
		if current == nil {
			current = &ListNode{Val: sum % 10}
			head = current
		} else {
			current.Next = &ListNode{Val: sum % 10}
			current = current.Next
		}
	}
	return head
}
