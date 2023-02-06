package lc_18_4sum

func fourSum(nums []int, target int) [][]int {
    return nSum(nums, 4, target)
}

func nSum(nums []int, n, targetSum int) [][]int {
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	return nSumCore(nums, 0, n, targetSum)
}

func nSumCore(nums []int, start, n, targetSum int) [][]int {
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

	// core
    var res [][]int
	if n < 2 {
		return res
	}
	if n == 2 {
		for l, r := start, len(nums)-1; l < r; {
			sum := nums[l] + nums[r]
			if sum < targetSum {
				l = moveRight(l)
			} else if sum > targetSum {
				r = moveLeft(r)
			} else {
				res = append(res, []int{nums[l], nums[r]})
				l = moveRight(l)
				r = moveLeft(r)
			}
		}
		return res
	}

	for i := start; i < len(nums); {
		lastRes := nSumCore(nums, i+1, n-1, targetSum-nums[i])
		for j := 0; j < len(lastRes); j++ {
			lastRes[j] = append(lastRes[j], nums[i])
		}
		res = append(res, lastRes...)
		i = moveRight(i)
	}

	return res
}