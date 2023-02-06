

class MyCalendar {

    private TreeMap<Integer, Integer> tm;

    public MyCalendar() {
    	tm = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = tm.floorKey(start);
        if(floor != null && start < tm.get(floor))
        	return false;
        Integer ceil = tm.ceilingKey(start);
        if(ceil != null && end > ceil)
        	return false;
        tm.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */