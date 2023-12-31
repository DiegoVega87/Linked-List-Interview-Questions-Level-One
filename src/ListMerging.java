public class ListMerging {

    /*
    * At our startup, we have two sorted linked lists containing customer transaction data. We need to merge
    * these lists into one sorted linked list to streamline our analysis process and improve efficiency.
    * Your task is to write a function that takes in the heads of both lists and merges them into one sorted
    * inked list. The function should return the head of the merged linked list.
    *
    * Example 1:
    *   ListNode l1 = new ListNode(1);
    *   l1.next = new ListNode(3);
    *   l1.next.next = new ListNode(5);
    *
    *   ListNode l2 = new ListNode(2);
    *   l2.next = new ListNode(4);
    *   l2.next.next = new ListNode(6);
    *
    *   mergedList should be: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    *
    * Example 2:
    *   ListNode l1 = new ListNode(1);
    *   l1.next = new ListNode(2);
    *   l1.next.next = new ListNode(3);
    *
    *   ListNode l2 = new ListNode(4);
    *   l2.next = new ListNode(5);
    *   l2.next.next = new ListNode(6);
    *
    *   MergedList should be: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    *
     * */

    public static void main(String[] args){

        //Test 1:
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        System.out.println("print l1: " );
        printList(l1);
        System.out.println();

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        System.out.println("print l2: " );
        printList(l2);
        System.out.println();

        ListNode mergedList = mergeSortedLists(l1, l2);
        System.out.println("print mergedList: " );
        printList(mergedList);
        System.out.println();


        //Test2
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        System.out.println("print l1: " );
        printList(l1);
        System.out.println();

        l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        System.out.println("print l2: " );
        printList(l2);
        System.out.println();

        mergedList = mergeSortedLists(l1, l2);
        System.out.println("print mergedList: " );
        printList(mergedList);
        System.out.println();

    }

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode l3 = new ListNode(0);
        ListNode tail = l3;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        while(ptr1 != null && ptr2 != null){

            if(ptr1.val <= ptr2.val){
                tail.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                tail.next = ptr2;
                ptr2 = ptr2.next;
            }

            tail = tail.next;
        }

        while(ptr1 != null){
            tail.next = ptr1;
            tail = tail.next;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            tail.next = ptr2;
            tail = tail.next;
            ptr2 = ptr2.next;
        }

        return l3.next;
    }

    public static void printList(ListNode head){

        if(head == null){
            return;
        }
        System.out.print(head.val + "--> ");
        printList(head.next);
    }
}
