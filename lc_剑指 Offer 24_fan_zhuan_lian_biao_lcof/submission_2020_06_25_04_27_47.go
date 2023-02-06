package lc_剑指 Offer 24_fan_zhuan_lian_biao_lcof

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var newHead *ListNode
    for head != nil {
        tmp := head.Next
        head.Next = newHead
        newHead = head
        head = tmp
    }
    return newHead
}