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

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeSortedLists(l1, l2);


        //Test2
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        mergedList = mergeSortedLists(l1, l2);

    }

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode l3 = null;
        ListNode tail = null;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        while(ptr1 != null || ptr2 != null){

            assert ptr1 != null;
            if(ptr1.val >= ptr2.val){

                if(l3 == null){
                    l3 = ptr1;
                }else{
                    if(tail == null){
                        tail = ptr1;
                        l3.next = tail;
                    }else{
                        tail.next = ptr1;
                        tail = tail.next;
                    }
                }
                ptr1 = ptr1.next;
            }else{

                if(l3 == null){
                    l3 = ptr2;
                }else{
                    if(tail == null){
                        tail = ptr2;
                        l3.next = tail;
                    }else{
                        tail.next = ptr2;
                        tail = tail.next;
                    }
                }
            }

            ptr2 = ptr2.next;
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

        return l3;
    }
}
