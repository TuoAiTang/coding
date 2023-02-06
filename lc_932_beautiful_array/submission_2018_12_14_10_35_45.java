

class Solution {
    private Map<Integer, int[]> mem = new HashMap<>();
    public int[] beautifulArray(int N) {
        int [] m = mem.get(N);
    	if(m != null)
    		return m;
        int [] ans = new int[N];
        if(N == 1)
        	ans[0] = 1;
        else{
        	int i = 0;
        	for(int odd : beautifulArray((N + 1) / 2))
        		ans[i++] = 2 * odd - 1;
        	for(int even : beautifulArray(N / 2))
        		ans[i++] = 2 * even;
        }
        mem.put(N, ans);
        return ans;
    }
}