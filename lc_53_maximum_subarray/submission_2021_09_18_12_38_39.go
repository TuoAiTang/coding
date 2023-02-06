package lc_53_maximum_subarray

func maxSubArray(nums []int) int {
	// dp[i] = 以i结尾的最大子数组之和
	// dp[i] = dp[i-1] + nums[i] or dp[i-1]
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	ans := dp[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = max(nums[i], dp[i-1] + nums[i])
		ans = max(ans, dp[i])
	}
	return ans
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

