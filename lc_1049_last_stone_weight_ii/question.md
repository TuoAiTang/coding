「每日一题 1049 - 最后一块石头的重量 II」
「难度」: Medium
「标签」: 数组、动态规划
「题目」: 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。

每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：


	如果 x == y，那么两块石头都会被完全粉碎；
	如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。


最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。

 

示例 1：

输入：stones = [2,7,4,1,8,1]
输出：1
解释：
组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。


示例 2：

输入：stones = [31,26,33,21,40]
输出：5


 

提示：


	1 <= stones.length <= 30
	1 <= stones[i] <= 100


「提示1」Think of the final answer as a sum of weights with + or - sign symbols infront of each weight.  Actually, all sums with 1 of each sign symbol are possible.
「提示2」Use dynamic programming: for every possible sum with N stones, those sums +x or -x is possible with N+1 stones, where x is the value of the newest stone.  (This overcounts sums that are all positive or all negative, but those don't matter.)
「题解」: https://leetcode-cn.com/problems/last-stone-weight-ii/solution/