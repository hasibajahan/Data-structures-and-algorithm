//problem statement: Given the head of a singly linked list, reorder the list to be in the following form: L0→Ln→L1→Ln-1→L2→Ln-2→…


//code
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class ReorderList {
    public void reorder(ListNode head) {
        //first find the middle of the list and split the list
        ListNode slow=head, fast=head;//slow moves one step, while fast moves two steps
        
        //the fast pointer either points to the last node(if odd lengthed list) or the second last node(if even lengthed list)
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse the second half
        ListNode second=slow.next;//as after the previous loop the slow pointer stops at the middle node(if odd) or the middle-left node(if even)
        
        slow.next=null;// split the two halves

        ListNode prev=null;
        while(second!=null){
            ListNode nextNode=second.next; // create a pointer to the next node
            second.next=prev;// reverse the current node's pointer
            prev=second;// move the previous
            second=nextNode; //move the "second" pointer as well
        }

        //merge the two lists alternatively
        ListNode first=head;// head of the first half
        second=prev; //head of the second half

        while(second!=null){
            
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            //link first→second→next of first
            first.next=second;
            second.next=temp1;

            first=temp1;
            second=temp2;
        }
    }
    public static void main(String[] args) {
        ReorderList rl=new ReorderList();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        rl.reorder(head);

        //print the reordered list
        ListNode current=head;
        while(current!=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
    }
}

//output: 1 5 2 4 3
// time complexity: O(n) each traversal is O(n).
// space complexity: O(1) since we are reordering the list in place.