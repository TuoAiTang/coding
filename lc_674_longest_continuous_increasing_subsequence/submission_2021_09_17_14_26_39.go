package lc_674_longest_continuous_increasing_subsequence

func findLengthOfLCIS(nums []int) int {
	/*
		dp[i] = 以i结尾的最长的连续子序列
		dp[i] = dp[i-1] + 1 if nums[i-1] < nums[i]
		ans = max(dp[i], i in 0,n)
	 */
	if len(nums) == 0 {
		return 0
	}
	ans := 1
	dp := make([]int, len(nums))
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}

	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			dp[i] = dp[i-1] + 1
		}
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
