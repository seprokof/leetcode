package main

import (
	"testing"
)

func TestAddTwoNumbers(t *testing.T) {
	cases := []struct {
		in1  *ListNode
		in2  *ListNode
		want *ListNode
	}{
		{makeList([]int{2, 4, 3}), makeList([]int{5, 6, 4}), makeList([]int{7, 0, 8})},
		{makeList([]int{0}), makeList([]int{0}), makeList([]int{0})},
		{makeList([]int{9, 9, 9, 9, 9, 9, 9}), makeList([]int{9, 9, 9, 9}), makeList([]int{8, 9, 9, 9, 0, 0, 0, 1})},
	}
	for _, c := range cases {
		got := AddTwoNumbers(c.in1, c.in2)
		if !equal(got, c.want) {
			t.Errorf("AddTwoNumbers(%v, %v) produced %v, want %v", c.in1, c.in2, got, c.want)
		}
	}
}

// Creates singly-linked list from given slice values returning head of the list.
func makeList(values []int) *ListNode {
	var result, head *ListNode
	for _, v := range values {
		if result == nil {
			result = &ListNode{Val: v}
			head = result
		} else {
			result.Next = &ListNode{Val: v}
			result = result.Next
		}
	}
	return head
}

// Checks if two lists contain the same values
func equal(left, right *ListNode) bool {
	for ; left != nil || right != nil; left, right = left.Next, right.Next {
		if left == nil || right == nil {
			return false
		} else if left.Val != right.Val {
			return false
		}
	}
	return true
}
