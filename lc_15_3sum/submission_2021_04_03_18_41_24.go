package lc_15_3sum

func threeSum(nums []int) [][]int {
	var res [][]int
	if len(nums) < 3 {
		return res
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})

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

	for i := 0; i < len(nums); {
		if nums[i] > 0 {
			break
		}
		for l, r := i+1, len(nums)-1; l < r; {
			sum := nums[i] + nums[l] + nums[r]
			if sum < 0 {
				l = moveRight(l)
			} else if sum > 0 {
				r = moveLeft(r)
			} else {
				res = append(res, []int{nums[i], nums[l], nums[r]})
				l = moveRight(l)
				r = moveLeft(r)
			}
		}
		i = moveRight(i)
	}
	return res
}