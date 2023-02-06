

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        for(int n : nums1)
            hs.add(n);
        
        Set<Integer> res = new HashSet<>();
        
        for(int n : nums2)
            if(hs.contains(n))
                res.add(n);
        
        int [] ans = new int [res.size()];
        Iterator<Integer> it = res.iterator();
        int index = 0;
        while(it.hasNext())
            ans[index++] = it.next();
        
        return ans;
    }
}