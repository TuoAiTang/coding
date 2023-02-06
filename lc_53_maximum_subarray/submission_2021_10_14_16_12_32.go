package lc_53_maximum_subarray

func maxSubArray(nums []int) int {
	/*
		dp[i] = 以i结尾的最大的子序列和
		dp[i] = 1. dp[i-1] + nums[i] (if dp[i-1] > 0)
				2. nums[i]
	 */
	if len(nums) == 0 {
		return 0
	}
	lastMax := nums[0]
	ans := lastMax
	for i := 1; i < len(nums); i++ {
		if lastMax > 0 {
			lastMax += nums[i]
		} else {
			lastMax = nums[i]
		}
		ans = max(ans, lastMax)
	}
	return ans
}

func max(a ...int) int {
	res := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] > res {
			res = a[i]
		}
	}
	return res
}

