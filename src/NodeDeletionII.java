public class NodeDeletionII {

    /*
    * As our company's user base is growing rapidly, we want to optimize the performance of our application.
    * One potential bottleneck is the time it takes to remove the nth node from the end of a linked list.
    * We need a function that takes the head of a linked list and the position of the node to remove from the end,
    * and returns the head of the updated linked list.
    *
    * Example 1:
    *   head = 1 -> 2 -> 3 -> 4 -> 5
    *   n = 2
    *   Output: 1 -> 2 -> 3 -> 5
    * Explanation: The second node from the end is 4. After removing it, the updated linked list becomes 1 -> 2 -> 3 -> 5.
    *
    * Example 2:
    *   head = 1 -> 2 -> 3 -> 4 -> 5
    *   n = 5;
    *   Output = 2 -> 3 -> 4 -> 5
    * Explanation: The fifth node from the end is 1. After removing it, the updated linked list becomes 2 -> 3 -> 4 -> 5.
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
        System.out.println("Print the list");
        printList(node1);
        System.out.println("Remove node 4");
        printList(removeNthFromEnd(node1, 2));
        System.out.println();
        System.out.println("Remove node 5");
        printList(removeNthFromEnd(node5, 1));
        System.out.println();
        printList(node4);
        System.out.println();
        System.out.println("Remove node 4");
        printList(removeNthFromEnd(node4, 1));



    }
    public static ListNode removeNthFromEnd(ListNode head, int n){

        if(n == 0 || head == null){
            return head;
        }
        ListNode ptr = head;
        int nodesCount = 0;

        while(ptr != null){
            nodesCount++;
            ptr = ptr.next;
        }

        if(n > nodesCount){
            return head;
        }
        if(n == nodesCount){
            return head.next;
        }


        nodesCount = nodesCount - n;

        ListNode prev = head;
        ListNode curr = head.next;

        while(nodesCount  > 1){

            nodesCount--;
            prev = curr;
            curr = curr.next;

        }

        prev.next = curr.next;

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
