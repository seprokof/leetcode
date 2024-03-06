package main

import (
	"testing"
)

func TestHasCycle(t *testing.T) {
	cases := []struct {
		in1  []int
		in2  int
		want bool
	}{
		{[]int{3, 2, 0, -4}, 1, true},
		{[]int{1, 2}, 0, true},
		{[]int{1}, -1, false},
	}
	for _, c := range cases {
		got := HasCycle(makeList(c.in1, c.in2))
		if got != c.want {
			t.Errorf("HasCycle(%v) produced %v, want %v", c.in1, got, c.want)
		}
	}
}

// Creates singly-linked list with possible cycle from given slice values returning head of the list.
// Pos is used to denote the index of the node that tail's next pointer is connected to.
func makeList(values []int, pos int) *ListNode {
	var result, head, cycle *ListNode
	for i, v := range values {
		if result == nil {
			result = &ListNode{Val: v}
			head = result
		} else {
			result.Next = &ListNode{Val: v}
			result = result.Next
		}
		if pos == i {
			cycle = result
		}
	}
	if cycle != nil {
		result.Next = cycle
	}
	return head
}
