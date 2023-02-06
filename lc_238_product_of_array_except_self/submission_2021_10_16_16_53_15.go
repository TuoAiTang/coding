package lc_238_product_of_array_except_self

func productExceptSelf(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}

	preP := make([]int, len(nums)+1)
	sufP := make([]int, len(nums)+1)

	preP[0] = 1
	sufP[len(nums)] = 1

	for i := 1; i <= len(nums); i++ {
		preP[i] = preP[i-1] * nums[i-1]
	}

	for i := len(nums) - 1; i >= 0; i-- {
		sufP[i] = sufP[i+1] * nums[i]
	}

	res := make([]int, len(nums))
	res[0] = sufP[1]
	res[len(nums)-1] = preP[len(nums)-1]
	for i := 1; i <= len(nums)-2; i++ {
		res[i] = sufP[i+1] * preP[i]
	}

	return res
}
