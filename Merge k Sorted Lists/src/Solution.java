import java.util.*;
public class Solution {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    //This problem works like merge sort
    //We can merge each two of them first and then merge the results
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        } 
        else{
            return mergeK(lists,0,lists.length-1);
        }
    }
    private ListNode mergeK(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        else if(start==end-1){
            return merge(lists[start],lists[end]);
        }
        else{
            int mid = (start+end)/2;
            return merge(mergeK(lists,start,mid),mergeK(lists,mid+1,end));
        }
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(node1!=null||node2!=null){
            if(node1==null){
                result.next = node2;
                result = result.next;
                node2 = node2.next;
            }
            else if(node2==null){
                result.next = node1;
                result = result.next;
                node1 = node1.next;                
            }
            else{
                if(node1.val<=node2.val){
                    result.next = node1;
                    node1 = node1.next;
                }
                else{
                    result.next = node2;
                    node2 = node2.next;
                }
                result = result.next;
            }
        }
        return temp.next;
    }
}
