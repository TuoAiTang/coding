

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyList = new ArrayList<>();
        int i = 0;
        for(long a = 1; a <= Integer.MAX_VALUE; a *= 2)
        	for(long b = a; b <= Integer.MAX_VALUE; b *= 3)
        		for(long c = b; c <= Integer.MAX_VALUE; c *= 5)
        			uglyList.add((int)c);

        Collections.sort(uglyList);
        return uglyList.get(n - 1);
    }
}