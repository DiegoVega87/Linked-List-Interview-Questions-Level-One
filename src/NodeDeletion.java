class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}
}
public class NodeDeletion {

    /*
    * Your startup has built a linked list to store important client and financial data. However, sometimes you may
    * need to delete a node in this list due to data being outdated or irrelevant. Write a function that given
    * a node in the list and the list head, deletes that node in an efficient manner and returns the updated list.
    *
    * Example 1:
    *   node = 3 -> 4 -> 5
    *   head = 1 -> 2 -> 3 -> 4 -> 5
    *   Output = head = 1 -> 2 -> 3 -> 4 -> 5
    *
    * Example 2:
    *   node = 2 -> 3 -> 4
    *   node = 2 -> 3 -> 4
    *   Output = 1 ->3-> 4 -> 5
    *
     * */

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printList(node1);
        System.out.println();
        printList(deleteNode(node1, node1));
        System.out.println();
        printList(deleteNode(node3, node1));
        System.out.println();
        printList(deleteNode(node5, node1));



    }

    public static ListNode deleteNode(ListNode node, ListNode head){

        /*
        *   Case empty LinkedList, null node
        *   Case head
        *   Case node in the middle
        *   Case tail
        *   Case node not found
        * */

        if(node == null || head == null){
            return head;
        }

        if(head.val == node.val){
           return head.next;
        }

        ListNode curr = head;
        ListNode ptr = head.next;

        while(ptr != null){

            if(ptr.val == node.val){
                curr.next = ptr.next;
                return head;
            }

            curr = ptr;
            ptr = ptr.next;
        }

        return head;
    }

    public static void printList(ListNode head){

        if(head == null){
            return;
        }
        System.out.print(head.val + "--> ");
        printList(head.next);
    }
}
