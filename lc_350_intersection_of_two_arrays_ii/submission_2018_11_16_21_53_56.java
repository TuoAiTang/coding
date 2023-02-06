

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] res = new int[nums1.length];
        int i = 0, j = 0, idx = 0;
        while(i < nums1.length && j < nums2.length){
        	if(nums1[i] > nums2[j]) j++;

        	else if(nums1[i] < nums2[j]) i++;

        	else{
        		res[idx++] = nums1[i];
        		i++;
        		j++;
        	}
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}