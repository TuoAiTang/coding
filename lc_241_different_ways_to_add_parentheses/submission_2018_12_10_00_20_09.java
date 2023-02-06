

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
    	Map<String, List<Integer>> mem = new HashMap<>();
        return ways(input, mem);
    }

    private List<Integer> ways(String input, Map<String, List<Integer>> mem){
    	List<Integer> ans = mem.get(input);
    	if(ans != null) return ans;
    	ans = new ArrayList<>();

    	for(int i = 0; i < input.length(); i++){
    		char c = input.charAt(i);
    		if(c == '+' || c == '-' || c == '*'){
    			String left_input = input.substring(0, i);
    			String right_input = input.substring(i + 1);
    			List<Integer> left_ans = ways(left_input, mem);
    			List<Integer> right_ans = ways(right_input, mem);
    			for(int a : left_ans)
    				for(int b : right_ans){
    					if(c == '+')
    						ans.add(a + b);
    					if(c == '-')
    						ans.add(a - b);
    					if(c == '*')
    						ans.add(a * b);
    				}
    		}
    	}

    	if(ans.isEmpty())
    		ans.add(Integer.valueOf(input));

    	mem.put(input, ans);
    	return ans;
    }
}