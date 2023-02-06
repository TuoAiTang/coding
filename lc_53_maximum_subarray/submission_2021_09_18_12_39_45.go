package lc_53_maximum_subarray

func maxSubArray(nums []int) int {
	// dp[i] = 以i结尾的最大子数组之和
	// dp[i] = dp[i-1] + nums[i] or dp[i-1]
	if len(nums) == 0 {
		return 0
	}
	dp := nums[0]
	ans := dp
	for i := 1; i < len(nums); i++ {
		dp = max(nums[i], dp + nums[i])
		ans = max(ans, dp)
	}
	return ans
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

