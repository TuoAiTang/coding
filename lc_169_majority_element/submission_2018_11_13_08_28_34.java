

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if(hm.get(num) > nums.length / 2)
                return num;
        }
        return -1;
    }
}