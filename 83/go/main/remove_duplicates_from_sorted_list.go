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

func DeleteDuplicates(head *ListNode) *ListNode {
	for current := head; current != nil && current.Next != nil; {
		if current.Val == current.Next.Val {
			if current.Next.Next != nil {
				current.Next = current.Next.Next
			} else {
				current.Next = nil
			}
		} else {
			current = current.Next
		}
	}
	return head
}
