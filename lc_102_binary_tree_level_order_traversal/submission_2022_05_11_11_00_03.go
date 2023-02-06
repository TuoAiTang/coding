package lc_102_binary_tree_level_order_traversal

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
     if root == nil {
		return nil
	}
	var res [][]int
	var q []*TreeNode
	q = append(q, root)
	for len(q) != 0 {
		var thisLevel []int
        size := len(q)
		for i := 0; i < size; i++ {
			node := q[0]
            q = q[1:]
			thisLevel = append(thisLevel, node.Val)
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
        res = append(res, thisLevel)
	}

	return res
}