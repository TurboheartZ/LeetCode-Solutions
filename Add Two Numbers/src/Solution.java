
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        int carry = 0;
        while(l1!=null&&l2!=null){
            temp.next = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            temp.next = new ListNode((l1.val+carry)%10);
            carry = (l1.val+carry)/10;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            temp.next = new ListNode((l2.val+carry)%10);
            carry = (l2.val+carry)/10;
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return root.next;
    }
}
