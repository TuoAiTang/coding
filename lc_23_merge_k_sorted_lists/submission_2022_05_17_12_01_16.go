package lc_23_merge_k_sorted_lists

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func mergeKLists(lists []*ListNode) *ListNode {
	return mergeKListsPartition(lists, 0, len(lists) - 1)
}

func mergeKListsPartition(lists []*ListNode, l, r int) *ListNode {
	if l == r {
		return lists[l]
	}
	
	if l > r {
		return nil
	}
	
	mid := (l + r) / 2
	
	return mergeTwoLists(mergeKListsPartition(lists, l, mid), mergeKListsPartition(lists, mid + 1, r))
}

func mergeTwoLists(a, b *ListNode) *ListNode {
	if a == nil {
		return b
	}

	if b == nil {
		return a
	}

	if a.Val < b.Val {
		a.Next = mergeTwoLists(a.Next, b)
		return a
	} else {
		b.Next = mergeTwoLists(a, b.Next)
		return b
	}
}