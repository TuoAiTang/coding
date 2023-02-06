「每日一题 189 - 轮转数组」
「难度」: Medium
「标签」: 数组、数学、双指针
「题目」: 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

 

示例 1:

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]


示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]

 

提示：


	1 <= nums.length <= 105
	-231 <= nums[i] <= 231 - 1
	0 <= k <= 105


 

进阶：


	尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
	你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？








「提示1」The easiest solution would use additional memory and that is perfectly fine.
「提示2」The actual trick comes when trying to solve this problem without using any additional memory. This means you need to use the original array somehow to move the elements around. Now, we can place each element in its original location and shift all the elements around it to adjust as that would be too costly and most likely will time out on larger input arrays.
「提示3」One line of thought is based on reversing the array (or parts of it) to obtain the desired result. Think about how reversal might potentially help us out by using an example.
「提示4」The other line of thought is a tad bit complicated but essentially it builds on the idea of placing each element in its original position while keeping track of the element originally in that position. Basically, at every step, we place an element in its rightful position and keep track of the element already there or the one being overwritten in an additional variable. We can't do this in one linear pass and the idea here is based on <b>cyclic-dependencies</b> between elements.
「题解」: https://leetcode-cn.com/problems/rotate-array/solution/