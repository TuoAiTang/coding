「每日一题 700 - 二叉搜索树中的搜索」
「难度」: Easy
「标签」: 树、二叉搜索树、二叉树
「题目」: 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。

 

示例 1:



输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]


示例 2:

输入：root = [4,2,7,1,3], val = 5
输出：[]


 

提示：


	数中节点数在 [1, 5000] 范围内
	1 <= Node.val <= 107
	root 是二叉搜索树
	1 <= val <= 107



「题解」: https://leetcode-cn.com/problems/search-in-a-binary-search-tree/solution/