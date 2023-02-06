

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
        	if(nums1[i] > nums2[j]) j++;

        	else if(nums1[i] < nums2[j]) i++;

        	else{
        		res.add(nums1[i]);
        		i++;
        		j++;
        	}
        }
        int ans[] = new int[res.size()];
        int idx = 0;
        for(Integer num : res)
        	ans[idx++] = num;
        return ans;
    }
}