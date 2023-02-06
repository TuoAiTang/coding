

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> ans = new ArrayList<>();
        for(int x = left; x <= right; x++)
        	if(isSelfDeviding(x))
        		ans.add(x);
        return ans;
    }

    private boolean isSelfDeviding(int num){
    	int x = num;
    	while(x > 0){
    		int y = x % 10;
    		if(y == 0) return false;
    		if(num % y != 0) return false;
    		x /= 10;
    	}
    	return true;
    }
}