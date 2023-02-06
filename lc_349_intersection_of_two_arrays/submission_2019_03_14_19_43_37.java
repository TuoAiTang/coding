

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        for(int n : nums1)
            hs.add(n);
        
        List<Integer> res = new ArrayList<>();
        
        for(int n : nums2)
            if(hs.contains(n)){
                res.add(n);
                hs.remove(n);
            }
        
        int [] ans = new int [res.size()];
        
        int index = 0;
        for(int n : res)
            ans[index++] = n;
        
        return ans;
    }
}