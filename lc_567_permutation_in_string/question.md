「每日一题 567 - 字符串的排列」
「难度」: Medium
「标签」: 哈希表、双指针、字符串、滑动窗口
「题目」: 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

 

示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").


示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false


 

提示：


	1 <= s1.length, s2.length <= 104
	s1 和 s2 仅包含小写字母


「提示1」Obviously, brute force will result in TLE. Think of something else.
「提示2」How will you check whether one string is a permutation of another string?
「提示3」One way is to sort the string and then compare. But, Is there a better way?
「提示4」If one string is a permutation of another string then they must one common metric. What is that?
「提示5」Both strings must have same character frequencies, if  one is permutation of another. Which data structure should be used to store frequencies?
「提示6」What about hash table?  An array of size 26?
「题解」: https://leetcode-cn.com/problems/permutation-in-string/solution/