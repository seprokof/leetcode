package main

import "testing"

func TestMergeTwoLists(t *testing.T) {
	cases := []struct {
		in1, in2, want *ListNode
	}{
		{makeList([]int{1, 2, 4}), makeList([]int{1, 3, 4}), makeList([]int{1, 1, 2, 3, 4, 4})},
		{makeList([]int{}), makeList([]int{}), makeList([]int{})},
		{makeList([]int{}), makeList([]int{0}), makeList([]int{0})},
	}
	for _, c := range cases {
		got := MergeTwoLists(c.in1, c.in2)
		if !equal(got, c.want) {
			t.Errorf("MergeTwoLists(%q, %q) == %q, want %q", c.in1, c.in2, got, c.want)
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

// Checks if two lists contain the same values
func equal(left, right *ListNode) bool {
	for ; left != nil; left, right = left.Next, right.Next {
		if left.Val != right.Val {
			return false
		}
	}
	return true
}
