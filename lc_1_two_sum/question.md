「每日一题 1 - 两数之和」
「难度」: Easy
「标签」: 数组、哈希表
「题目」: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。


示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]


示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


 

提示：


	2 <= nums.length <= 104
	-109 <= nums[i] <= 109
	-109 <= target <= 109
	只会存在一个有效答案


 

进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

「提示1」A really brute force way would be to search for all possible pairs of numbers but that would be too slow. Again, it's best to try out brute force solutions for just for completeness. It is from these brute force solutions that you can come up with optimizations.
「提示2」So, if we fix one of the numbers, say <code>x</code>, we have to scan the entire array to find the next number <code>y</code> which is <code>value - x</code> where value is the input parameter. Can we change our array somehow so that this search becomes faster?
「提示3」The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
「题解」: https://leetcode-cn.com/problems/two-sum/solution/