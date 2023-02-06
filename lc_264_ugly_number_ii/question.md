「每日一题 264 - 丑数 II」
「难度」: Medium
「标签」: 哈希表、数学、动态规划、堆（优先队列）
「题目」: 给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。

 

示例 1：

输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。


示例 2：

输入：n = 1
输出：1
解释：1 通常被视为丑数。


 

提示：


	1 <= n <= 1690


「提示1」The naive approach is to call <code>isUgly</code> for every number until you reach the n<sup>th</sup> one. Most numbers are <i>not</i> ugly. Try to focus your effort on generating only the ugly ones.
「提示2」An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
「提示3」The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L<sub>1</sub>, L<sub>2</sub>, and L<sub>3</sub>.
「提示4」Assume you have U<sub>k</sub>, the k<sup>th</sup> ugly number. Then U<sub>k+1</sub> must be Min(L<sub>1</sub> * 2, L<sub>2</sub> * 3, L<sub>3</sub> * 5).
「题解」: https://leetcode-cn.com/problems/ugly-number-ii/solution/