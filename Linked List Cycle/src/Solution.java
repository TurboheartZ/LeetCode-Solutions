
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        else{
            ListNode slow = head;
            ListNode fast = head.next.next;
            while(fast!=null&&fast.next!=null&&slow!=fast){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(slow==fast){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
