package lc_剑指 Offer 63_gu_piao_de_zui_da_li_run_lcof

func maxProfit(prices []int) int {
    if len(prices) < 2 {
        return 0
    }



    dp := make([]int, len(prices))
    var maxProfit int
    // dp[i] 到i之前买入股票的最低价格
    dp[1] = prices[0]
    for i := 2; i < len(prices); i++ {
        dp[i] = min(dp[i-1], prices[i-1])
    }

    for i := 1; i < len(prices); i++ {
        maxProfit = max(maxProfit, prices[i]-dp[i])
    }

    return maxProfit
}

func min(a, b int) int {
    if a > b {
        return b
    }
    return a
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}