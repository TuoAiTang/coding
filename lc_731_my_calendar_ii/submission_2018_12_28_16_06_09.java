

class MyCalendarTwo {
	private List<int []> booked;
	private List<int []> overlaps;
    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        //check if it overlap with overlaps
        for(int [] itv : overlaps)
        	if(Math.max(itv[0], start) < Math.min(itv[1], end))
        		return false;

        //keep tracking the overlaps and add the interval to booked at last
        for(int [] itv : booked){
        	int os = Math.max(start, itv[0]);
        	int oe = Math.min(end, itv[1]);
        	if(os < oe) overlaps.add(new int [] {os, oe});
        }

        booked.add(new int [] {start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */