package lc_144_binary_tree_preorder_traversal

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    var res []int
    if root == nil {
        return res
    }
    res = append(res, root.Val)
    
    left := preorderTraversal(root.Left)  
    res = append(res, left...)
    
    right := preorderTraversal(root.Right)  
    res = append(res, right...)
    return res
}