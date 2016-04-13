
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //I would try to find the last node and the k node before the last one and link the last node to the first node and use the k node as
    //the beginning node
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        else{
            ListNode last = head;
            ListNode ks = head;//K's next is the new beginning node            
            int len = 1;
            while(last.next!=null){
                last = last.next;
                len++;
            }
            int shift = k%len;
            if (shift==0) return head;
            else{
                int i;
                last = head;
                for(i=0;i<shift&&last.next!=null;i++){
                    last = last.next;
                }
                while(last.next!=null){
                    last = last.next;
                    ks = ks.next;
                }
                ListNode newBegin = ks.next;
                ks.next = null;
                last.next = head;
                return newBegin;                
            }
        }
    }
}
