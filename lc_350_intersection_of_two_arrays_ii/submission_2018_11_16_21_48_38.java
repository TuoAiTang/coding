

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int num : nums1)
    		map1.put(num, map1.getOrDefault(num, 0) + 1);
        for(int num : nums2)
        	map2.put(num, map2.getOrDefault(num, 0) + 1);

        for(int key : map2.keySet()){
        	int count = Math.min(map1.getOrDefault(key, 0), map2.get(key));
        	for(int i = 0; i < count; i++)
        		res.add(key);
        }


        int ans[] = new int[res.size()];
        int idx = 0;
        for(Integer num : res)
        	ans[idx++] = num;
        return ans;
    }
}