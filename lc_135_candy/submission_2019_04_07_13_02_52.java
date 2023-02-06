

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //memo[i] 记录第i个孩子最少需要分到的糖果数
        int [] memo = new int [n];
        int ans = 0;
        for(int i = 0; i < n; i++)
            candy(i, ratings, memo);
        for(int m : memo)
            ans += m;
        return ans;
    }
    
    public int candy(int i, int [] ratings, int [] memo){
        if(memo[i] != 0) return memo[i];
        boolean left = false, right = false;
        if(i + 1 < ratings.length && ratings[i] > ratings[i + 1])
            right = true;
        if(i - 1 >= 0 && ratings[i] > ratings[i - 1])
            left = true;
        if(left && right)
            memo[i] = 1 + Math.max(candy(i - 1, ratings, memo), 
                               candy(i + 1, ratings, memo));
        else if(!left && !right)
            memo[i] = 1;
        else
            memo[i] = left ? candy(i - 1, ratings, memo) + 1 : candy(i + 1, ratings, memo) + 1;
        return memo[i];
    }
}