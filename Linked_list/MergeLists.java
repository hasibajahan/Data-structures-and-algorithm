//Problem statement: two sorted linked lists are given, merge them into a single sorted linked list and return it. 
// The new list should be made by splicing together the nodes of the first two lists.

//code
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeLists {
     
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy=new ListNode(-1);
            ListNode temp=dummy;

            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    temp.next=list1;
                    list1=list1.next;
                }else{
                    temp.next=list2;
                    list2=list2.next;
                    //remember in case of both values being equal just add either of them to the new list 
                }
                temp=temp.next;
            }

            //if one list is completely added but other one has remaining nodes, add it
            if(list1!=null){
                temp.next=list1;
            }else{
                temp.next=list2;
            }
            return dummy.next;
    }

    public static void main(String[] args) {
        MergeLists ml=new MergeLists();
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);

        ListNode list2=new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);

        ListNode mergedList=ml.mergeTwoLists(list1, list2);
        while(mergedList!=null){
            System.out.print(mergedList.val+" ");
            mergedList=mergedList.next;
        }
    }
    
}

//output: 1 1 2 3 4 4
//time complexity:O(n+m) where n and m are the lengths of the two linked lists
//space complexity: O(1) since we are not using any extra space for the new list, we are just rearranging the existing nodes.