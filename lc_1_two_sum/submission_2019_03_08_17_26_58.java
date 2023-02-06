

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int [] res = new int [2];
        for(int i = 0; i < nums.length; i++){
            Integer index = m.get(target - nums[i]);
            if(index != null)
                return new int [] {index, i};
            m.put(nums[i], i);
        }
        throw new IllegalArgumentException("nums do not sum to" + target);
    }
}