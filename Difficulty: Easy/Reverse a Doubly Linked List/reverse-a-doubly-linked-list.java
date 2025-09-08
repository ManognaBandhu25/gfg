/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node curr = head;
      Node front =  null;
      
     while(curr.next != null){
         front = curr.next;
         curr.next = curr.prev;
         curr.prev = front;
         curr = curr.prev;
     }
     curr.next = curr.prev;
     curr.prev = null;
     return curr;
    }
}