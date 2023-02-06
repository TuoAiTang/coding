package lc_122_best_time_to_buy_and_sell_stock_ii

func maxProfit(prices []int) int {
	if len(prices) < 2 {
		return 0
	}
    
    var res int

	for i := 1; i < len(prices); i++ {
        if prices[i] - prices[i-1] > 0 {
            res += prices[i] - prices[i-1] 
        }
	}

	return res
}