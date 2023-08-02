public class LinkedListReversion {

    /*
    * Our startup has a feature that allows users to create and manipulate linked lists. We have noticed that some
    * users are having trouble reversing their linked lists. We want you to implement a function that takes the head
    * of a singly linked list and reverses the list, returning the reversed list. The function should take the head
    * node as input and should be able to handle empty lists.
    *
    * Example 1:
    *   Input: 1->2->3->4->5->NULL
    *   Output: 5->4->3->2->1->NULL
    *
    * Example 2:
    *   Input: NULL
    *   Input: NULL
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
        System.out.println("Print the list");
        printList(node1);
        System.out.println();
        ListNode head = reverseList(node1);
        printList(head);
        System.out.println("\nEmpty list");
        head = reverseList(null);
        printList(head);
        System.out.println("\nTwo nodes: ");
        head = reverseList(node4);
        printList(head);



    }
    public static ListNode reverseList(ListNode head){

        if(head == null || head.next == null) {
            return head;
        }
        ListNode reversed = null;
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            prev.next = reversed;
            reversed = prev;
            prev = curr;
            curr = curr.next;
        }

        prev.next = reversed;
        reversed = prev;

        return reversed;
    }

    public static void printList(ListNode head){

        if(head == null){
            return;
        }
        System.out.print(head.val + "--> ");
        printList(head.next);
    }
}
