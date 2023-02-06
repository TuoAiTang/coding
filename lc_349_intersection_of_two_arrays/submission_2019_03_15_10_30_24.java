

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] nums1_ = nums1, nums2_ = nums2;
        if(nums1.length > nums2.length){
            nums1_ = nums2;
            nums2_ = nums1;
        }        
        Set<Integer> hs = new HashSet<>();
        for(int n : nums1_)
            hs.add(n);
        
        List<Integer> res = new ArrayList<>();
        
        for(int n : nums2_)
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