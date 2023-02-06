「每日一题 572 - 另一棵树的子树」
「难度」: Easy
「标签」: 树、深度优先搜索、二叉树、字符串匹配、哈希函数
「题目」: 

给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。

二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。

 

示例 1：

输入：root = [3,4,5,1,2], subRoot = [4,1,2]
输出：true


示例 2：

输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
输出：false


 

提示：


	root 树上的节点数量范围是 [1, 2000]
	subRoot 树上的节点数量范围是 [1, 1000]
	-104 <= root.val <= 104
	-104 <= subRoot.val <= 104




「提示1」Which approach is better here- recursive or iterative?
「提示2」If recursive approach is better, can you write recursive function with its parameters?
「提示3」Two trees <b>s</b> and <b>t</b> are said to be identical if their root values are same and their left and right subtrees are identical. Can you write this in form of recursive formulae?
「提示4」Recursive formulae can be: 
isIdentical(s,t)= s.val==t.val AND isIdentical(s.left,t.left) AND isIdentical(s.right,t.right)
「题解」: https://leetcode-cn.com/problems/subtree-of-another-tree/solution/