package lc_300_longest_increasing_subsequence

func lengthOfLIS(nums []int) int {
	// dp[i] 以i结尾的最长递增子序列长度
	// dp[i] = max(dp[j] + 1, j < i && nums[j] < nums[i])
	// dp[i] = max(dp[j], j < i && nums[j] >= nums[i])
	// ans = max(dp[i], i in 0,n)
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		dp[i] = 1
	}
	ans := 1
	for i := 1; i < len(nums); i++ {
		for j := i - 1; j >= 0; j-- {
			if nums[j] < nums[i] {
				dp[i] = max(dp[j]+1, dp[i])
			}
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

