
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }	
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null){
            return;
        }
        else{
            TreeLinkNode parent = root;
            TreeLinkNode cur;
            while(parent.left!=null){
                cur = parent;
                while(cur!=null){
                    cur.left.next = cur.right;
                    if(cur.next!=null){
                        cur.right.next = cur.next.left;
                    }
                    cur = cur.next;
                }
                parent = parent.left;
            }
        }
    }
}
