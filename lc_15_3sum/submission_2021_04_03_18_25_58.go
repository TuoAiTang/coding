package lc_15_3sum

func threeSum(nums []int) [][]int {
	var res [][]int
	hm := map[string]bool{}
	m := make(map[int]int, len(nums))
	sort.SliceStable(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	for index, num := range nums {
		m[num] = index
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			break
		}
		if i > 1 {
			cur := nums[i-1]
			for i < len(nums) && cur == nums[i] {
				i++
			}
		}

		for j := i + 1; j < len(nums); j++ {
			key := -nums[i] - nums[j]
			if index, ok := m[key]; ok && index != i && index != j {
				tup := []int{nums[i], nums[j], key}
				exKey := getKey(tup)
				if _, ok := hm[exKey]; !ok {
					res = append(res, tup)
					hm[exKey] = true
				}
			}

			cur := nums[j]
			for j < len(nums) && nums[j] == cur {
				j++
			}
			j--
		}
	}
	return res
}

func getKey(tup []int) string {
	sort.SliceStable(tup, func(i, j int) bool {
		return tup[i] < tup[j]
	})
	return fmt.Sprintf("%d,%d,%d", tup[0], tup[1], tup[2])
}