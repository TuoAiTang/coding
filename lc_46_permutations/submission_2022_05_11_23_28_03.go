package lc_46_permutations

func permute(nums []int) [][]int {
	n := len(nums)
	var res [][]int
	var cur []int
	set := make([]int, n)
	var dfs func()
	dfs = func() {
		if len(cur) == n {
			curCopy := make([]int, n)
			copy(curCopy, cur)
			res = append(res, curCopy)
			return
		}
		for i := 0; i < n; i++ {
			if set[i] == 1 {
				continue
			}
			set[i] = 1
			cur = append(cur, nums[i])
			dfs()
			set[i] = 0
			cur = cur[:len(cur)-1]
		}
	}
	dfs()
	return res
}