

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> ans = new ArrayList<>();
        for(int x = left; x <= right; x++)
        	if(isSelfDeviding(x))
        		ans.add(x);
        return ans;
    }

    private boolean isSelfDeviding(int num){
    	String str = String.valueOf(num);
    	for(int i = 0; i < str.length(); i++){
    		int x = str.charAt(i) - '0';
    		if(x == 0 || num % x != 0)
    			return false;
    	}
    	return true;
    }
}