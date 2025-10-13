// User function Template for Java

/*class Node
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
    public static Node partition(Node node, int x) {
        Node less = new Node(-1);
        Node greater = new Node(-1);
        Node equal = new Node(-1);
    
        Node lessH = less;
        Node greaterH = greater;
        Node equalH = equal;
        Node curr = node;
        
        while(curr!=null) {
            if(curr.data < x) {
                less.next = curr;
                less = curr;
            } else if(curr.data == x) {
                equal.next = curr;
                equal = curr;
            } else {
                greater.next = curr;
                greater = curr;
            }
            curr = curr.next;
        }
        
        less.next = equalH.next;
        equal.next = greaterH.next;
        greater.next = null;
        
        return lessH.next;
    }
}