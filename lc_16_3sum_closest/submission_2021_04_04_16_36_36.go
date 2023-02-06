package lc_16_3sum_closest

func threeSumClosest(nums []int, target int) int {
	if len(nums) < 3 {
		return 0
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	// func define
	moveRight := func(l int) int {
		for cur := nums[l]; l < len(nums) && nums[l] == cur; l++ {
		}
		return l
	}

	moveLeft := func(r int) int {
		for cur := nums[r]; r > 0 && nums[r] == cur; r-- {
		}
		return r
	}

	minDiff := target - (nums[0] + nums[1] + nums[2])
	res := nums[0] + nums[1] + nums[2]
	for i := 0; i < len(nums); {
		for l, r := i+1, len(nums)-1; l < r; {
			sum := nums[i] + nums[l] + nums[r]
			diff := target - sum
			if diff == 0 {
				return sum
			}
			if diff < 0 {
				if minDiff > -diff {
					minDiff = -diff
					res = sum
				}
				r = moveLeft(r)
			} else {
				if minDiff > diff {
					minDiff = diff
					res = sum
				}
				l = moveRight(l)
			}
		}
		i = moveRight(i)
	}
	return res
}