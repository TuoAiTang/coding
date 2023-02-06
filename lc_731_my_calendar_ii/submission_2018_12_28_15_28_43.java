

class MyCalendarTwo {
	private List<Interval> booked;
	private List<Interval> overlaps;
	class Interval{
		public int start, end;
		Interval(int s, int e) {start = s; end = e;}
	}
    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        //check if it overlap with overlaps
        for(Interval itv : overlaps)
        	if(Math.max(itv.start, start) < Math.min(itv.end, end))
        		return false;

        //keep tracking the overlaps and add the interval to booked at last
        for(Interval itv : booked){
        	int os = Math.max(start, itv.start);
        	int oe = Math.min(end, itv.end);
        	if(os < oe) overlaps.add(new Interval(os, oe));
        }

        booked.add(new Interval(start, end));
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */