

class MyLinkedList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {this.val = val; this.next = null;}
    }
    
    ListNode dummy;
    ListNode tail;
    int length;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy = new ListNode(0); 
        tail = dummy;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= length) return -1;
        ListNode p = dummy.next;
        while(index-- > 0)
            p = p.next;
        return p.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode p = new ListNode(val);
        p.next = dummy.next;
        dummy.next = p;
        if(length == 0) tail = p;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode p = new ListNode(val);
        tail.next = p;
        tail = p;
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > length) return;
        if(index == length){
            addAtTail(val);
            return;
        }
        ListNode pre = dummy;
        while(index-- > 0)
            pre = pre.next;
        ListNode p = new ListNode(val);
        p.next = pre.next;
        pre.next = p;
        length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;
        ListNode pre = dummy;
        int i = index;
        while(index-- > 0)
            pre = pre.next;
        if(i == length - 1) 
            tail = pre;
        pre.next = pre.next.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */