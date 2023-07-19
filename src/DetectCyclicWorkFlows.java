import java.util.HashMap;


public class DetectCyclicWorkFlows {

    /*
    * Our startup has a workflow management system that involves a series of linked tasks.
    * We suspect that some of these workflows have cycles, which can cause serious operational issues.
    * We need you to write a function that takes in the head of a workflow and determines whether, or not
    * a cycle exists within it. Your function should return a boolean value indicating the presence or absence
    * of the cycle. A cycle is present if there is some node in the list that can be revisited by traversing
    * the next pointer.
    *
    * Example 1:
    *   head = 1 -> 2 -> 3 -> 4 -> 5 -> 2
    *   Output = true
    *
    * Example 2:
    *   head = 1 -> 2 -> 3 -> 4 -> 5
    *   Output: false
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
        //node5.next = node2;

        System.out.println(hasCycle(node1));

    }

    public static boolean hasCycle(ListNode head){

        if(head == null || head.next == null){
            return false;
        }

        HashMap<Integer, Boolean> checker = new HashMap<>();

        while (head != null){
            boolean visited = checker.getOrDefault(head.val, false);

            if(visited){
                return true;
            }else{
                checker.put(head.val, true);
            }

            head = head.next;
        }

        return false;
    }

    public static void printList(ListNode head){

        if(head == null){
            return;
        }
        System.out.print(head.val + "--> ");
        printList(head.next);
    }
}
