
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode swapPairs(ListNode head) {
        if(head!=null&&head.next!=null){
            ListNode root = head.next;
            ListNode prev = head;
            ListNode desc = new ListNode(0);
            ListNode temp = new ListNode(0);
            //Use temp to denote the ancestor, in the next iteration, we need to connect the ancestor and the shifted new element.
            while(prev!=null&&prev.next!=null){
                desc = prev.next;
                temp.next = desc;
                prev.next = desc.next;
                desc.next = prev;
                temp = prev;
                prev = prev.next;
            }
            return root;
        }
        else{
            return head;
        }
    }
}
