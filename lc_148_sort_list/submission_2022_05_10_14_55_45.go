package lc_148_sort_list

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
    // write code here
	if head == nil || head.Next == nil {
		return head
	}

	fast := head.Next
	slow := head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	// slow 为中点/中点右侧的节点
	tmp := slow.Next
	slow.Next = nil

	l := sortList(head)
	r := sortList(tmp)

	h := &ListNode{}
	res := h
	for l != nil && r != nil {
		if l.Val < r.Val {
			res.Next = l
			l = l.Next
		} else {
			res.Next = r
			r = r.Next
		}
		res = res.Next
	}

	if l == nil {
		res.Next = r
	}
	if r == nil {
		res.Next = l
	}

	return h.Next
}