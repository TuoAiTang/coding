package lc_337_house_robber_iii

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int {
	memo := make(map[*TreeNode]int)
	return dfs(memo, root)
}

func dfs(memo map[*TreeNode]int, root *TreeNode) int {
	if root == nil {
		return 0
	}
	if ans, ok := memo[root]; ok {
		return ans
	}
	ans := max(root.Val + dfs(memo, safeLeft(root.Left)) + dfs(memo, safeRight(root.Left)) + dfs(memo, safeLeft(root.Right)) + dfs(memo, safeRight(root.Right)), //take root
			   dfs(memo, root.Left) + dfs(memo, root.Right)) // not take root
	memo[root] = ans
	return memo[root]
}

func safeLeft(root *TreeNode) *TreeNode{
	if root == nil {
		return nil
	}
	return root.Left
}

func safeRight(root *TreeNode) *TreeNode{
	if root == nil {
		return nil
	}
	return root.Right
}

func max(a ...int) int {
	res := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] > res {
			res = a[i]
		}
	}
	return res
}

func min(a ...int) int {
	res := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] < res {
			res = a[i]
		}
	}
	return res
}

