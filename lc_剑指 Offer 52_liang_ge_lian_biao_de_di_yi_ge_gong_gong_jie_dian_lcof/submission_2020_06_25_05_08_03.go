package lc_剑指 Offer 52_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    if headA == nil || headB == nil {
        return nil
    }
    l1 := getLen(headA)
    l2 := getLen(headB)
    if l1 < l2 {
        for i := 0; i < l2 - l1; i++ {
            headB = headB.Next
        }
    } else {
         for i := 0; i < l1 - l2; i++ {
            headA = headA.Next
        }
    }
    for headA != nil {
        if headA == headB {
            return headA
        }
        headA = headA.Next
        headB = headB.Next
    }
    return nil
}

func getLen(head *ListNode) int {
    l := 0
    for head != nil {
        head = head.Next
        l++
    }
    return l
}
