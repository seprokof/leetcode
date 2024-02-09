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

func MergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	var next, current, head *ListNode
	var stop bool
	for {
		if list1 == nil {
			next = list2
			stop = true
		} else if list2 == nil {
			next = list1
			stop = true
		} else if list1.Val > list2.Val {
			next = list2
			list2 = list2.Next
		} else {
			next = list1
			list1 = list1.Next
		}

		if head == nil {
			current = next
			head = current
		} else {
			current.Next = next
			current = current.Next
		}
		if stop {
			return head
		}
	}
}
