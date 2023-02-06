「每日一题 204 - 计数质数」
「难度」: Medium
「标签」: 数组、数学、枚举、数论
「题目」: 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

 

示例 1：

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。


示例 2：

输入：n = 0
输出：0


示例 3：

输入：n = 1
输出：0


 

提示：


	0 <= n <= 5 * 106


「提示1」Checking all the integers in the range [1, n - 1] is not efficient. Think about a better approach.
「提示2」Since most of the numbers are not primes, we need a fast approach to exclude the non-prime integers.
「提示3」Use Sieve of Eratosthenes.
「题解」: https://leetcode-cn.com/problems/count-primes/solution/