
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Use merge sort to solve this problem
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        else{
            ListNode temp = head.next;
            ListNode mid = head;
            while(temp!=null&&temp.next!=null){
                temp = temp.next.next;
                mid = mid.next;
            }
            ListNode head2 = mid.next;
            mid.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(head2);
            return merge(left,right);
        }
    }
    // public ListNode partition(ListNode head){
    //     if(head==null||head.next==null){
    //         return head;
    //     }
    //     else{
    //         ListNode temp = head;
    //         ListNode mid = head;
    //         ListNode head1 = head;
    //         while(temp!=null&&temp.next!=null){
    //             temp = temp.next.next;
    //             mid = mid.next;
    //         }
    //         ListNode head2 = mid.next;
    //         mid.next = null;
    //         ListNode left = partition(head1);
    //         ListNode right = partition(head2);
    //         return merge(left,right);
    //     }
    // }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode root = new ListNode(0);
        ListNode temp = new ListNode(0);
        temp = root;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        } 
        return root.next;
    }
}
