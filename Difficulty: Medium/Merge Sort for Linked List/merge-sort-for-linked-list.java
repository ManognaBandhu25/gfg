/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        Node temp=head;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        int[] arr=new int[c];
        temp=head;
        for(int i=0;i<c;i++)
        {
            arr[i]=temp.data;
            temp=temp.next;
        }
        Arrays.sort(arr);
        temp=head;
        int j=0;
        while(temp!=null)
        {
            temp.data=arr[j++];
            temp=temp.next;
        }
        return head;
    }
}