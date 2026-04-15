//Problem statement:Basic operations on singly linked list
import java.util.List;

class ListNode{
     int data;
     ListNode next;
     ListNode(int data){
          this.data=data;
          this.next=null;
     }
}

public class Basic_op{
     ListNode head;
     //Creation (Also insertion at the end)
     public void createList(int value){
          ListNode newNode=new ListNode(value);
          if(head==null){
               head=newNode; //if head is null the newNode will become the head
               return;
          }
          ListNode temp=head;
          //traverse till the end of the list
          while(temp.next!=null){
               temp=temp.next;
          }
          temp.next=newNode; //add the newNode at the end of the list
     }

     //Traversal
    public void traversal(){
          ListNode temp=head;
          while(temp!=null){
               System.out.print(temp.data+" -> ");
               temp=temp.next;
          }
          System.out.println("null");
     }

     //Insertion
     //1) at the beginning
     public void insertAtBeginning(int value){
          ListNode newNode=new ListNode(value);
          newNode.next=head; //point the newNode to the current head (first create the new link)
          head=newNode; //then update the head
     }

     //2)at the end - Already done in createList method
     //3)Insert Node at a specific position
     public void insertAtPosition(int value,int position){
          if(position==0){
               insertAtBeginning(value);
               return;
          }
          ListNode newNode=new ListNode(value);
          ListNode temp=head;

          for(int i=0;i<position-1;i++){
               if(temp==null){return;}
               temp=temp.next;
          }
          newNode.next=temp.next;//create the new link first
          temp.next=newNode;//then update the link
     }

     //Deletion 
     //1) at the beginning
     public void deleteAtStart(){
          if(head==null) return;
          head=head.next; //update the head to the next node, the old head will be garbage collected
     }

     //2) at the end
     public void deleteAtEnd(){
          if(head==null) return;

          //only one node is in the list
          if(head.next==null)
               {
               head=null;
               return;
          }

          ListNode temp=head;
          while(temp.next.next!=null){
               temp=temp.next;
          }
          //after the loop we are at the second last node, so we set the next pointer of this node to null

          temp.next=null;//last node removed.
     }

     //3) at a specific position
     public void deleteAtPosition(int pos){
          if(head==null) return;

          //only one node is in the list
          if(head.next==null){
               head=null;
               return;
          }
          if(pos==0){
               deleteAtStart();
               return;
          }
          ListNode temp=head;
          for(int i=0;i<pos-1;i++){
               if(temp==null) return;
               temp=temp.next;
          }
          //after the loop we are at the node just before the node to be deleted.
          if(temp.next==null) return;
          temp.next=temp.next.next;

     }
     //4)by value
     public void deleteByValue(int value){
          if(head==null) return;

          //if the head node itself holds the value to be deleted
          if(head.data==value){
               head=head.next; //update the head to the next node, the old head will be garbage collected
               return;
          }

          ListNode temp=head;
          //keep traversing until we reach the end of the list or find the value
          while(temp.next!=null && temp.next.data!=value)
          {
               temp=temp.next;
          }
          //after the loop we are at the node just before the node to be deleted.
          if(temp.next==null) return; //value not found in the list
          temp.next=temp.next.next; //update the link to skip the node to be deleted
     }

     //main method
     public static void main(String[] args) {
          Basic_op list=new Basic_op();
          list.createList(10);
          list.createList(20);
          list.createList(30);
          System.out.println("Original List:");
          list.traversal();

          System.out.println("after inserting 5 at the beginning:");
          list.insertAtBeginning(5);
          list.traversal();

          System.out.println("after inserting 25 at position 3:");
          list.insertAtPosition(25,3);
          list.traversal();

          System.out.println("After deleting the first node:");
          list.deleteAtStart();
          list.traversal();

          System.out.println("After deleting the last node:");
          list.deleteAtEnd();
          list.traversal();

          System.out.println("after deleting node at position 2:");
          list.deleteAtPosition(2);
          list.traversal();

          System.out.println("after deleting node with value 20:");
          list.deleteByValue(20);
          list.traversal();

     }
}

//output:
// Original List:
// 10 -> 20 -> 30 -> null
// after inserting 5 at the beginning:
// 5 -> 10 -> 20 -> 30 -> null
// after inserting 25 at position 3:
// 5 -> 10 -> 20 -> 25 -> 30 -> null
// After deleting the first node:
// 10 -> 20 -> 25 -> 30 -> null
// After deleting the last node:
// 10 -> 20 -> 25 -> null
// after deleting node at position 2:
// 10 -> 20 -> null
// after deleting node with value 20:
// 10 -> null