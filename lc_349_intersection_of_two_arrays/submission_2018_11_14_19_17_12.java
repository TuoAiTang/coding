

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> hs = new HashSet<>();
        for(int num : nums1)
            hs.add(num);
        for(int num : nums2){
            if(hs.contains(num)){
                res.add(num);
                hs.remove(num);
            }
        }
        int [] ans = new int[res.size()];
        for(int j = ans.length - 1; j >= 0; j--)
        	ans[j] = res.get(j);
        return ans;
    }
}