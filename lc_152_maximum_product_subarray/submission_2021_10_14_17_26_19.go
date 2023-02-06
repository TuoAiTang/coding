package lc_152_maximum_product_subarray

func maxProduct(nums []int) int {
	/*
		maxP[i] 以i结尾的连续子数组最大乘积
		minP[i] 以i结尾的连续子数组最小乘积

		maxP[i] =
		1. minP[i-1] * nums[i] (if nums[i] < 0)
		2. maxP[i-1] * nums[i] (if nums[i] > 0)
		3. nums[i]

		minP[i] =
		1. minP[i-1] * nums[i] (if nums[i] > 0)
		2. maxP[i-1] * nums[i] (if nums[i] < 0)
		3. nums[i]
	 */

	if len(nums) == 0 {
		return 0
	}

	ans, minP, maxP := nums[0], nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		lastMin, lastMax := minP, maxP
		minP = min(lastMin * nums[i], lastMax * nums[i], nums[i])
		maxP = max(lastMin * nums[i], lastMax * nums[i], nums[i])
		ans = max(ans, maxP)
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

func min(a ...int) int {
	res := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] < res {
			res = a[i]
		}
	}
	return res
}
