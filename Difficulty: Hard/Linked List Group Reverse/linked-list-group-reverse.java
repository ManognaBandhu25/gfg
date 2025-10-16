/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null||k==1) return head;
        Node p = new Node(0);
        p.next = head;
        Node prev = p,curr=head;
        int count=0;
        while(curr!=null) {
            count++; 
            curr=curr.next;
        }
        while(count>=k){
            curr=prev.next;
            Node next=curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev=curr;
            count -= k;
        }
        if(count%k!=0){
            curr=prev.next;
            Node next=curr.next;
            for(int i=1;i<count;i++){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
        }
        return p.next;

    }
}
