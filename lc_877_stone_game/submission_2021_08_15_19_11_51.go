package lc_877_stone_game


func stoneGame(piles []int) bool {
	if len(piles) == 0 {
		return false
	}

	// mp: cache max for piles<i,j>
	mp := make(map[string]int)
	return best(mp, piles, 0, len(piles)-1) > 0
}

func best(mp map[string]int, piles []int, i, j int) int {
	if j-i == 0 {
		return piles[i]
	}
	if j-i == 1 {
		return max(piles[i]-piles[j], piles[j]-piles[i])
	}
	if v, ok := mp[key(i, j)]; ok {
		return v
	}
	ans1 := piles[i] - best(mp, piles, i+1, j)
	ans2 := piles[j] - best(mp, piles, i, j-1)
	mp[key(i, j)] = max(ans1, ans2)
	return mp[key(i, j)]
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}

func key(i, j int) string {
	return fmt.Sprintf("%d-%d", i, j)
}

// best[i,j] --> max relative score
// best[i,j] = max(piles[i]-best(i+1, j), piles[j]-best(i,j-1))
// return best[i:j] > 0