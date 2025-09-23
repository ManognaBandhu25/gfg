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
        Node newHeadNode = null;
    	Node tempIterator = head;
    	Node tempIterator2 = new Node(0);
    	Stack<Node> stck = new Stack<Node>();
    	while (tempIterator != null) {
    		stck.push(tempIterator);
    		tempIterator = tempIterator.next;
    		if (stck.size() == k) {
    			while (!stck.isEmpty()) {
    				if (newHeadNode == null) {
    					newHeadNode = stck.pop();
    					tempIterator2 = newHeadNode;
    				} else {
    					tempIterator2.next = stck.pop();
    					tempIterator2 = tempIterator2.next;
    				}
    			}
    		}
    	}
    	while (!stck.isEmpty()) {
			if (newHeadNode == null) {
				newHeadNode = stck.pop();
				tempIterator2 = newHeadNode;
			} else {
				tempIterator2.next = stck.pop();
				tempIterator2 = tempIterator2.next;
			}
		}
    	tempIterator2.next = null;
        return newHeadNode;
    }
}