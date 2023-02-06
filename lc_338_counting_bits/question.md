「每日一题 338 - 比特位计数」
「难度」: Easy
「标签」: 位运算、动态规划
「题目」: 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。

 



示例 1：

输入：n = 2
输出：[0,1,1]
解释：
0 --> 0
1 --> 1
2 --> 10


示例 2：

输入：n = 5
输出：[0,1,1,2,1,2]
解释：
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


 

提示：


	0 <= n <= 105


 

进阶：


	很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
	你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）




「提示1」You should make use of what you have produced already.
「提示2」Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
「提示3」Or does the odd/even status of the number help you in calculating the number of 1s?
「题解」: https://leetcode-cn.com/problems/counting-bits/solution/