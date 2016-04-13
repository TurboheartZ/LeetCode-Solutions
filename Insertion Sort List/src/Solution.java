import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        else{
            ListNode headNow = new ListNode(-1);
            headNow.next = head;
            ListNode cur = head.next;
            ListNode prev = head;
            while(cur!=null){
                if(cur.val>=prev.val){
                    prev = cur;
                    cur = cur.next;
                }
                else{
                   ListNode search = headNow.next;
                   if(search.val>cur.val){//The first must be the smallest element, so compare it to the cur firstly
                       //Means cur is the smallest and should be insert at the first position
                       prev.next = cur.next;
                       cur.next = headNow.next;
                       headNow.next = cur;
                       cur = prev.next;//prev donot need to be updated
                   }
                   else{
                       while(search!=prev){
                           if(search.next.val>cur.val){
                               break;
                           }
                           else{
                               search = search.next;
                           }
                       }                       
                       prev.next = cur.next;
                       cur.next = search.next;
                       search.next = cur;
                       cur = prev.next;
                   }
                }
            }
            return headNow.next;
        }
    }
}
