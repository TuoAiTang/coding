

class MyHashSet {
    Entry [] lists;
    int size;
    
    class Entry{
        int key;
        Entry next;
        public Entry(int k) { key = k; next = null;} 
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        size = 10007;
        lists = new Entry [size];
    }
    
    public void add(int key) {
        int i = key % size;
        Entry e = lists[i];
        if(e == null)
            lists[i] = new Entry(key);
        else{
            while(e != null && e.key != key)
                e = e.next;
            if(e == null){
                Entry ne = new Entry(key);
                ne.next = lists[i];
                lists[i] = ne;
            }
        }
    }
    
    public void remove(int key) {
        int i = key % size;
        Entry e = lists[i];
        if(e == null)
            return;
        Entry pre = null;
        while(e != null && e.key != key){
            pre = e;
            e = e.next;
        }
        if(e != null){
            if(pre == null)
                lists[i] = e.next;
            else
                pre.next = e.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key % size;
        Entry e = lists[i];
        while(e != null && e.key != key)
            e = e.next;
        return e != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */