「每日一题 70 - 爬楼梯」
「难度」: Easy
「标签」: 记忆化搜索、数学、动态规划
「题目」: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶

示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶


 

提示：


	1 <= n <= 45


「提示1」To reach nth step, what could have been your previous steps? (Think about the step sizes)
「题解」: https://leetcode-cn.com/problems/climbing-stairs/solution/