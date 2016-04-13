
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    //First reverse the last half nodes
    //Then insert
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        else{
            //Find the mid node;
            ListNode fast = head;
            ListNode slow = head;
            while(fast!=null){
                if(fast.next==null||fast.next.next==null){
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode r = slow.next;//Reversion from this node(inclusive)
            ListNode s = r;
            ListNode p = null;
            while(s!=null){
                ListNode parent = s;
                s = s.next;
                parent.next = p;
                p = parent;
            }
            slow.next = null;
            ListNode n = head;
            while(n!=null&&p!=null){
                ListNode n2 = n.next;
                n.next = p;
                p = p.next;
                n = n.next;
                n.next = n2;
                n = n.next;
            }
        }
    }
}
