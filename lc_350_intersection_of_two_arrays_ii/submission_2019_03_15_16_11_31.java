

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int [] ans = new int [nums2.length];
        int index = 0;
        while(i++ < nums1.length && j++ < nums2.length){
            if(nums1[i - 1] == nums2[j - 1])
                ans[index++] = nums1[i - 1];
            else if(nums1[i - 1] < nums2[j - 1])
                j--;
            else
                i--;
        }
        return Arrays.copyOf(ans, index);
    }
}