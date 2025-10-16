/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
       
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
    if(fast != null){
        slow = slow.next;
    }
    while(slow != null){
        if(stack.pop() != slow.data){
            return false;
        }
        slow = slow.next;
    }
    return true; 
    }
}