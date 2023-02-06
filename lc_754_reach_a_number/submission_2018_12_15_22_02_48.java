

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = (int) Math.sqrt(target * 2);
        int sum = k * (k + 1) / 2;
        if(sum < target) sum += (++k);
        int d = sum - target;
        if(d % 2 == 0) return k;
        return k + 1 + (k % 2);
    }
}