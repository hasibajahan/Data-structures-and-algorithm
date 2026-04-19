//problem statement: Given the head of a linked list, check whether the list has a cycle or not.

//code
class ListNode{
  int val;
  ListNode next;
  ListNode(int val){
    this.val=val;
    this.next=null;
  }

}
public class CycleDetection{
  public boolean hasCycle(ListNode head){
    if(head==null || head.next==null){
      return false;
    }
    //using two pointers approach
    ListNode slow=head;
    ListNode fast=head;

    //both poiners will move in the same direction
    while(fast!=null && fast.next!=null){
      slow=slow.next;//slow pointer moves one step at a time
      fast=fast.next.next;//fast pointer moves two steps at a time

      //if fast pointer catches up to the slow pointer, then there is a cycle
      if(slow==fast)
      {
        return true;//cycle detected
      }
    }
    return false;
  }

  //main method
  public static void main(String[] args) {
    CycleDetection cd=new CycleDetection();
    //creating a linked list with a cycle
    ListNode head=new ListNode(1);
    ListNode second=new ListNode(2);
    head.next=second;
    //create a cycle
    second.next=head;
    System.out.println(cd.hasCycle(head));

  }
}
//output: 
//true

//time complexity:O(n), where n is the number of nodes in the linked list.
//space complexity:O(1) i.e. no extra space is used, only a constant amount of space for the two pointers.