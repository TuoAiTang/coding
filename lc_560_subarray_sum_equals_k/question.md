「每日一题 560 - 和为 K 的子数组」
「难度」: Medium
「标签」: 数组、哈希表、前缀和
「题目」: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。

 

示例 1：

输入：nums = [1,1,1], k = 2
输出：2


示例 2：

输入：nums = [1,2,3], k = 3
输出：2


 

提示：


	1 <= nums.length <= 2 * 104
	-1000 <= nums[i] <= 1000
	-107 <= k <= 107


「提示1」Will Brute force work here? Try to optimize it.
「提示2」Can we optimize it by using some extra space?
「提示3」What about storing sum frequencies in a hash table? Will it be useful?
「提示4」sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.

Can we use this property to optimize it.
「题解」: https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/