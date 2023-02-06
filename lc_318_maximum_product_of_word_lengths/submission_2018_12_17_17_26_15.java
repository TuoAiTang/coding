

class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int ans = 0;

        //pre-process 1 : sorting
        Arrays.sort(words, new Comparator<String>(){
        	@Override
        	public int compare(String a, String b){
        		return b.length() - a.length();
        	}
        });
        
        //pre-process 2 : mapping
        int [][] premap = new int[words.length][26];
        for(int i = 0; i < words.length; i++)
        	for(char c : words[i].toCharArray())
        		premap[i][c - 'a'] = 1;

        for(int i = 0; i < words.length; i++)
        	for(int j = i + 1; j < words.length; j++){
        		boolean hasCommon = false;
        		for(char c : words[j].toCharArray())
        			if(premap[i][c - 'a'] == 1){
        				hasCommon = true;
        				break;
        			}
        		if(!hasCommon){
        			ans = Math.max(ans, words[i].length() * words[j].length());
        			break;
        		}
        	}

        return ans;
    }
}