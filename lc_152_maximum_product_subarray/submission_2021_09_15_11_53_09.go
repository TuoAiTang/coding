package lc_152_maximum_product_subarray

func maxProduct(nums []int) int {
	// max(j) = 右边界为j的最大乘积连续子数组
	// min(j) = 右边界为j的最大乘积连续子数组
	// max(j) = max(max(j-1)*nums[j], min(j-1)*nums[j], nums[j])
	n := len(nums)
	if n == 0 {
		return 0
	}

	max := func(a, b int) int {
		if a < b {
			return b
		}
		return a
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	maxProduct, minProduct, ans := nums[0], nums[0], nums[0]
	for i := 1; i < n; i++ {
		preMax, preMin := maxProduct, minProduct
		maxProduct = max(preMax*nums[i], max(preMin*nums[i], nums[i]))
		minProduct = min(preMax*nums[i], min(preMin*nums[i], nums[i]))
		ans = max(ans, maxProduct)
	}


	return ans
}
