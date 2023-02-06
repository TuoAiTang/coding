

class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int ans = 0;

        //pre-process 1 : sorting
        // Arrays.sort(words, new Comparator<String>(){
        // 	@Override
        // 	public int compare(String a, String b){
        // 		return b.length() - a.length();
        // 	}
        // });
        
        //pre-process 2 : bit-operations
       	int [] map = new int [words.length];
       	for(int i = 0; i < words.length; i++)
       		for(char c : words[i].toCharArray())
       			map[i] |= (1 << (c - 'a'));

	    for(int i = 0; i < words.length; i++)
	    	for(int j = i + 1; j < words.length; j++)
	    		if((map[i] & map[j]) == 0)
	    			ans = Math.max(ans, words[i].length() * words[j].length());
	    			

        return ans;
    }
}