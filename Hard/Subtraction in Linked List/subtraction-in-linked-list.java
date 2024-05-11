//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        
        while(head1!=null && head1.data==0){
            head1=head1.next;
        }
        
        while(head2!=null && head2.data==0){
            head2=head2.next;
        }
        
        int n1=length(head1);
        int n2=length(head2);
        
        if(n1==0 && n2==0) return new Node(0);
        
        if(n2>n1){
            Node temp=head1;
            head1=head2;
            head2=temp;
        }
        
        if(n1==n2){
            Node curr1=head1,curr2=head2;
            while(curr1.data==curr2.data){
                curr1=curr1.next;
                curr2=curr2.next;
                if(curr1==null) return new Node(0);
            }
            if(curr2.data>curr1.data){
                Node temp=head1;
                head1=head2;
                head2=temp;
            }
        }
        
        Node h1=reverse(head1);
        Node h2=reverse(head2);
       
        Node ans=null;
        
        while (h1 != null) {
            int val1=h1.data; int val2=0;
            if(h2!=null) val2=h2.data;
            if(val1<val2){
                if(h1.next!=null){
                    h1.next.data-=1;
                }
                val1+=10;
            }
            
            Node curr = new Node(val1-val2);
            curr.next = ans;
            ans=curr;
            
            h1 = h1.next;
            if(h2!=null) h2 = h2.next;
        }
        
    while(ans!= null && ans.next!=null){
        if(ans.data==0){
        ans = ans.next;
        }
        else
        break;
        }
        return ans;
    }
    private int length(Node head){
        int length=0;
        while(head!=null){
            head=head.next;
            length++;
        }
        return length;
    }
    private Node reverse(Node head){
        Node curr=head,temp=null,prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
        
