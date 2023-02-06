

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack();
        int n = T.length;
        if(n == 0) return null;
        s.push(0);
        
        int [] res = new int [n];
        int i = 1;
        while(i < n){
            if(s.isEmpty() || T[s.peek()] >= T[i])
                s.push(i++);
            else{
                res[s.peek()] = i - s.peek();
                s.pop();
            }
        }
        
        return res;
    }
}