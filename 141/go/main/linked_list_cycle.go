package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func HasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	p1, p2 := head, head.Next.Next
	for p1 != nil && p2 != nil && p2.Next != nil {
		if p1 == p2 {
			return true
		}
		p1 = p1.Next
		p2 = p2.Next.Next
	}
	return false
}
