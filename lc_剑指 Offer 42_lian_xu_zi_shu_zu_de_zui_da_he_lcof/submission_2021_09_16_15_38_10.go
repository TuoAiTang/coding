package lc_剑指 Offer 42_lian_xu_zi_shu_zu_de_zui_da_he_lcof

func maxSubArray(nums []int) int {
	// dp[i] 以i结尾的子数组最大的和
	// ans = max dp[i...j]
	// dp[i] = dp[i-1] + nums[i] or nums[i]
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	ans := dp[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = max(dp[i-1]+nums[i], nums[i])
		ans = max(ans, dp[i])
	}
	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

