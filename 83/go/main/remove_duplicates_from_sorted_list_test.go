package main

import (
	"testing"
)

func TestDeleteDuplicates(t *testing.T) {
	cases := []struct {
		in   *ListNode
		want *ListNode
	}{
		{makeList([]int{1, 1, 2}), makeList([]int{1, 2})},
		{makeList([]int{1, 1, 2, 3, 3}), makeList([]int{1, 2, 3})},
	}
	for _, c := range cases {
		inCopy := copyList(c.in)
		got := DeleteDuplicates(c.in)
		if !equal(got, c.want) {
			t.Errorf("DeleteDuplicates(%q) == %q, want %q", inCopy, got, c.want)
		}
	}
}

// Creates singly-linked list from given values returning head of the list
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

// Creates a copy of given list
func copyList(head *ListNode) *ListNode {
	var result, copyHead *ListNode
	for current := head; current != nil; current = current.Next {
		if result == nil {
			result = &ListNode{Val: current.Val}
			copyHead = result
		} else {
			result.Next = &ListNode{Val: current.Val}
			result = result.Next
		}
	}
	return copyHead
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
