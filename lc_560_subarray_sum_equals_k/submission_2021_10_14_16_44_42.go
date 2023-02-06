package lc_560_subarray_sum_equals_k

func subarraySum(nums []int, k int) int {
	/*
		遍历累加前缀和，当前前缀和为sum, 若之前存在过前缀和 sum-k, 那么之前那个index到目前位置的和为k, 解的个数取决与index的个数
		用map存储前缀和出现的次数, ans += map[sum-k]
	 */

	if len(nums) == 0 {
		return 0
	}

	mp := make(map[int]int)
	mp[0] = 1
	ans := 0
	pre := 0
	for i := 0; i < len(nums); i++ {
		pre += nums[i]
		if count, ok := mp[pre-k]; ok {
			ans += count
		}
		mp[pre] ++
	}

	return ans
}
