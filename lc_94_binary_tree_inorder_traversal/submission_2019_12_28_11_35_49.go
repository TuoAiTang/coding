package lc_94_binary_tree_inorder_traversal

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}
	stack := Stack{}
	stack.Push(root)
	for !stack.IsEmpty() {
		for stack.Top().Left != nil {
			stack.Push(stack.Top().Left)
		}
		for !stack.IsEmpty() {
			p := stack.Pop()
			res = append(res, p.Val)
			if p.Right != nil {
				stack.Push(p.Right)
				break
			}
		}
	}
	return res
}

type Stack []*TreeNode

func (s *Stack) Pop() *TreeNode {
	if s.IsEmpty() {
		panic("empty!")
	}
	val := (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return val
}

func (s *Stack) Push(val *TreeNode) {
	*s = append(*s, val)
}

func (s *Stack) Top() *TreeNode {
	if s.IsEmpty() {
		panic("empty!")
	}
	return (*s)[len(*s)-1]
}

func (s *Stack) IsEmpty() bool {
	return len(*s) == 0
}
