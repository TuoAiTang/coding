package lc_剑指 Offer 63_gu_piao_de_zui_da_li_run_lcof

func maxProfit(prices []int) int {
    if len(prices) < 2 {
        return 0
    }


    var maxProfit int
    var minPrice int
    
    minPrice = prices[0]

    for i := 1; i < len(prices); i++ {
        maxProfit = max(maxProfit, prices[i]-minPrice)
        minPrice = min(minPrice, prices[i])
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