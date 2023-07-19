import java.util.ArrayList;


public class LListPalindromeChecker {

    /*
    * A fintech startup has a website where users can create accounts and enter their personal information.
    * The company wants to ensure that their platform is secure by implementing a function that checks
    * if a user's personal information stored in a singly linked list is a palindrome. Write a function that
    * takes the head of the singly linked list and returns true if the linked list is a palindrome, or false otherwise.
    *
    * Example 1:
    *   Input: 1 -> 2 -> 3 -> 2 -> 1
    *   Output: true
    *
    * Example 2:
    *   Input: 1 -> 2 -> 3 -> 4 -> 5
    *   Output: false
    * */

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        for(int i = 0; i < size/2; i++){
            if(list.get(i) != list.get(size-1-i)){
                return false;
            }
        }

        return true;
    }
}
