

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) return intervals;
        radixSort(intervals);
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        int size = 1;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= res.get(size - 1).end)
                res.get(size - 1).end = Math.max(res.get(size - 1).end,
                                              intervals.get(i).end);
            else{
                res.add(intervals.get(i));
                size++;
            }  
        }
        return res;
    }
    
    public void radixSort(List<Interval> intervals){
        int max_val = Integer.MIN_VALUE;
        for(Interval itv : intervals)
            max_val = Math.max(max_val, itv.start);
        
        Interval [] buffer = new Interval [intervals.size()];
        int rate = 1;
        while(max_val / rate > 0){
            int [] count = new int[11];
            
            for(Interval itv : intervals){
                int index = itv.start / rate % 10 + 1;
                count[index]++;
            }
            
            for(int i = 1; i < 11; i++)
                count[i] += count[i - 1];
            
            
            for(Interval itv : intervals){
                int index = itv.start / rate % 10;
                buffer[count[index] ++] = itv;
            }
            
            for(int i = 0; i < buffer.length; i ++)
                intervals.set(i, buffer[i]);
            
            rate *= 10;
        }
        
        buffer = null;  //clear to ready for gc
    }
}