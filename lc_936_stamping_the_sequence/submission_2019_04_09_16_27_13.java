

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char [] targetArr = target.toCharArray();
        int n = target.length();
        List<Integer> res = new ArrayList<>();
        int total = 0;
        int [] seen = new int[n];
        while(total < n){
            boolean found = false;
            for(int i = 0; i <= n - stamp.length(); i++){
                if(seen[i] == 1) continue;
                int l = unStamp(stamp, targetArr, i);
                if(l == 0) continue;
                total += l;
                res.add(i);
                seen[i] = 1;
                found = true;
            }
            if(!found) return new int [0];
        }
        int size = res.size();
        int [] ans = new int [size];
        for(int index : res)
            ans[--size] = index;
        return ans;
    }
    //O(stamp.length)
    int unStamp(String stamp, char [] target, int s){
        int l = stamp.length();
        for(int i = 0; i < stamp.length(); i ++){
            if(target[s + i] == '?')
                l--;
            else if(target[s + i] != stamp.charAt(i))
                return 0;
        }
        if(l != 0)
            for(int j = s; j < s + stamp.length(); j++)
                target[j] = '?';
        return l;
    }
}