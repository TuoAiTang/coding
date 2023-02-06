「每日一题 41 - 缺失的第一个正数」
「难度」: Hard
「标签」: 数组、哈希表
「题目」: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

 

示例 1：

输入：nums = [1,2,0]
输出：3


示例 2：

输入：nums = [3,4,-1,1]
输出：2


示例 3：

输入：nums = [7,8,9,11,12]
输出：1


 

提示：


	1 <= nums.length <= 5 * 105
	-231 <= nums[i] <= 231 - 1


「提示1」Think about how you would solve the problem in non-constant space.  Can you apply that logic to the existing space?
「提示2」We don't care about duplicates or non-positive integers
「提示3」Remember that O(2n) = O(n)
「题解」: https://leetcode-cn.com/problems/first-missing-positive/solution/