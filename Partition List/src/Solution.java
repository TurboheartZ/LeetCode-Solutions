
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Use two pointers to build up two list
    public static ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        else{
            ListNode smaller = new ListNode(-1);
            ListNode larger = new ListNode(-1);
            ListNode smallerroot = smaller;
            ListNode largerroot = larger;              
            ListNode check = head;
            while(check!=null){
                if(check.val<x){
                    smaller.next = check;
                    smaller = smaller.next;
                }
                else{
                    larger.next = check;
                    larger = larger.next;
                }
                check = check.next;
            }
            larger.next = null;
            smaller.next = largerroot.next;
            return smallerroot.next;
        }
    }
}
