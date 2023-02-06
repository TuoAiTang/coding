package lc_189_rotate_array

func rotate(nums []int, k int)  {
    k %= len(nums)
	if k != 0 {
        left, right := 0, len(nums) - k
        for i := 0; i < k; i++ {
            nums[left], nums[right] = nums[right], nums[left]
            left++
            right++
        }
        rotate(nums[left:], k)
	}
}