

class MyHashMap {
    
    Entry [] lists;
    int size;
    
    class Entry{
        int key;
        int val;
        Entry next;
        public Entry(int k, int v) {key = k; val = v; next = null;}
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 10007;
        lists = new Entry [size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashcode = key % size;
        Entry e = lists[hashcode];
        if(e == null)
            lists[hashcode] = new Entry(key, value);
        else{
            while(e != null && e.key != key)
                e = e.next;
            if(e != null)
                e.val = value;
            else{
                Entry ne = new Entry(key, value);
                ne.next = lists[hashcode];
                lists[hashcode] = ne;
            }          
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashcode = key % size;
        Entry e = lists[hashcode];
        while(e != null && e.key != key)
            e = e.next;
        return e == null ? -1 : e.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashcode = key % size;
        Entry e = lists[hashcode];
        Entry pre = null;
        while(e != null && e.key != key){
            pre = e;
            e = e.next;
        }
        if(e != null){
            if(pre == null)
                lists[hashcode] = e.next;
            else
                pre.next = e.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */