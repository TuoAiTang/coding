「每日一题 5 - 最长回文子串」
「难度」: Medium
「标签」: 字符串、动态规划
「题目」: 给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

 

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。


示例 2：

输入：s = "cbbd"
输出："bb"


 

提示：


	1 <= s.length <= 1000
	s 仅由数字和英文字母组成


「提示1」How can we reuse a previously computed palindrome to compute a larger palindrome?
「提示2」If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?
「提示3」Complexity based hint:</br>
If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
「题解」: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/