package lc_213_house_robber_ii

func rob(nums []int) int {
	/*
		假设打劫第一间房屋，那一定不能打劫倒数第一件房屋，打劫的范围为第一间到倒数第二间, 不用考虑首尾相连
		假设不打劫第一间房屋，那可以打劫倒数第一件房屋，打劫的范围为第二间到倒数第一间, 不用考虑首尾相连
		robRange(start, end) 代表从start到end不考虑首尾相连的最大收入

		ans = max(nums[0] + robRange(2, len(nums) - 2),
					robRange(1, len(nums) - 1))
	*/

	if len(nums) == 1 {
		return nums[0]
	}

	if len(nums) == 2 {
		return max(nums[0], nums[1])
	}

	robRange := func(start, end int) int {
		if start > end {
			return 0
		}
		if start == end {
			return nums[start]
		}

		prePreAnswer := nums[start]
		preAnswer := max(nums[start], nums[start+1])
		for i := start + 2; i <= end; i++ {
			ans := max(prePreAnswer+nums[i], preAnswer)
			prePreAnswer = preAnswer
			preAnswer = ans
		}

		return preAnswer
	}

	return max(nums[0]+robRange(2, len(nums)-2), robRange(1, len(nums)-1))
}


func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}
