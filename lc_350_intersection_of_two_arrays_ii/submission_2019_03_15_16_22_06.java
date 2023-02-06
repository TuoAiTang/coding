

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int num : nums1)
    		map1.put(num, map1.getOrDefault(num, 0) + 1);
        for(int num : nums2)
        	map2.put(num, map2.getOrDefault(num, 0) + 1);
        
        for(int n : map1.keySet())
            for(int i = Math.min(map1.get(n), map2.getOrDefault(n, 0)); i > 0; i--)
                res.add(n);
        
        int index = 0;
        int [] ans = new int[res.size()];
        
        for(int n : res)
            ans[index++] = n;
        
        return ans;
    }
}