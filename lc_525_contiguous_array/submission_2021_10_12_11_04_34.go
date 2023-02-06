package lc_525_contiguous_array

func findMaxLength(nums []int) int {
	/*
		mp[diff] = 01数量查为diff时第一次出现的位置index
		再次遍历到diff时的index为j, mp[diff]=i, 此时得到 i,j 这一段连续子数组
	 */
	diff := 0
	ans := 0
	dm := make(map[int]int)
	dm[0] = -1
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			diff++
		} else {
			diff--
		}

		if index, ok := dm[diff]; ok {
			ans = max(ans, i - index)
		} else {
			dm[diff] = i
		}
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

