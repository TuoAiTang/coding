package lc_724_find_pivot_index

func pivotIndex(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	sums := make([]int, len(nums))
	sums[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		sums[i] += sums[i-1] + nums[i]
	}

	for i := 0; i < len(nums); i++ {
		left := sums[i] - nums[i]
		right := sums[len(nums)-1] - sums[i]
		if left == right {
			return i
		}
	}

	return -1
}
