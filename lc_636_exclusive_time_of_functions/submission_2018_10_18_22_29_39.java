

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
    	String [] s = logs.get(0).split(":");
    	int [] res = new int[n];
    	stack.push(Integer.parseInt(s[0]));
    	int pre = Integer.parseInt(s[2]);
    	int i = 1;
    	while(i < logs.size()) {
    		s = logs.get(i).split(":");
    		if(s[1].equals("start")) {
    			if(!stack.isEmpty())
    				res[stack.peek()] += Integer.parseInt(s[2]) - pre;
    			stack.push(Integer.parseInt(s[0]));
    			pre = Integer.parseInt(s[2]);
    		}else {
    			res[stack.pop()] += Integer.parseInt(s[2]) - pre + 1;
    			pre = Integer.parseInt(s[2]) + 1;
    		}
    		i++;
    	}
    	return res;
    }
}