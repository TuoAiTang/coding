

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [] cur = new double[100];
        cur[0] = poured;

        for(int i = 0; i < query_row; i++){ 
        	double [] next = new double[100]; 	
        	for(int j = 0; j <= i; j++)
        		if(cur[j] > 1.0){
        			next[j    ] += (cur[j] - 1.0) / 2;
        			next[j + 1] += (cur[j] - 1.0) / 2;
        		}
        	cur = next;
        }

        return Math.min(1.0, cur[query_glass]);
    }
}