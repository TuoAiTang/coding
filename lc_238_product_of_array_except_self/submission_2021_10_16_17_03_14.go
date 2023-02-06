package lc_238_product_of_array_except_self

func productExceptSelf(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}

	// 1. 先遍历前缀积 res[i]=i左边所有元素乘积
	res := make([]int, len(nums))
	res[0] = 1
	for i := 1; i < len(nums); i++ {
		res[i] = res[i-1] * nums[i-1]
	}

	// 2. 从最后一个为止开始向前求后缀和postMul 同时更新res[i] = 除i以外的所有元素乘积
	postMul := 1
	for i := len(nums) - 1; i >= 0; i-- {
		res[i] = res[i] * postMul
		postMul *= nums[i]
	}

	return res
}
