package lc_673_number_of_longest_increasing_subsequence

func findNumberOfLIS(nums []int) int {
	/*
		dp[i] 以i结尾的最长递增子序列的长度
		dp[i] = max(dp[j]+1, j < i && nums[j]<nums[i])
		count[i] 以i结尾的最长递增子序列的数量
		for j in (0, i):
			if get larger length: 
				count[i] = count[j]
			if get same length: 
				count[i] += count[j]
	 */
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	count := make([]int, len(nums))
	for i := 0 ; i < len(nums); i++ {
		dp[i] = 1
		count[i] = 1
	}
	maxLen := 1
	for i := 1; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if dp[j] + 1 > dp[i] {
					dp[i] = dp[j]+1
					count[i] = count[j]
				} else if dp[j] + 1 == dp[i] {
					count[i] += count[j]
				}
			}
		}
		maxLen = max(maxLen, dp[i])
	}

	ans := 0
	for i := 0; i < len(nums); i++ {
		if dp[i] == maxLen {
			ans += count[i]
		}
	}
	return ans
}


func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
