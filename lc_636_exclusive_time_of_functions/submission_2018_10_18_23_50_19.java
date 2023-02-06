

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
    	String [] s = logs.get(0).split(":");
    	int [] res = new int[n];
        int id;
        int stamp;
    	int pre = 0;
    	for (String string : logs) {
    		s = string.split(":");
            id = Integer.parseInt(s[0]);
            stamp = Integer.parseInt(s[2]);
    		if(s[1].equals("start")) {
    			if(!stack.isEmpty())
    				res[stack.peek()] += stamp - pre;
    			stack.push(id);
    			pre = stamp;
    		}else {
    			res[stack.pop()] += stamp - pre + 1;
    			pre = stamp + 1;
    		}
		} 
    	return res;
    }
}