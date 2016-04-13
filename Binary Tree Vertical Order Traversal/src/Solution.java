import  java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    //Build a new class to record both the TreeNode and its index in the vertival traverse sequence
    //Actually, we can also use another queue to record the index, which is a substitute of this class
    public class Node{
        public TreeNode treenode;
        public int index;
        public Node(TreeNode x, int y){
            this.treenode =  x;
            this.index = y;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        else{
            Queue<Node> que = new LinkedList<Node>();
            HashMap<Integer,List<Integer>> record = new HashMap<Integer,List<Integer>>();
            que.offer(new Node(root,0));
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(que.size()>0){
                Node target = que.poll();
                int i = target.index;
                min = Math.min(min,i);
                max = Math.max(max,i);
                TreeNode t = target.treenode;
                if(record.containsKey(i)==true){
                    List<Integer> data = record.get(i);
                    data.add(t.val);
                    record.replace(i,data);
                }
                else{
                    List<Integer> data = new ArrayList<Integer>();
                    data.add(t.val);
                    record.put(i,data);
                }
                if(t.left!=null){
                    que.offer(new Node(t.left,i-1));                    
                }
                if(t.right!=null){
                    que.offer(new Node(t.right,i+1));        
                }
            }
            for(int i = min; i<=max; i++){
                //if(record.containsKey(i)){
                //We do not need to check if the item exist or not, since we have n, we must have n-1
                    result.add(record.get(i));
                //}
            }
            return result;
        }
    }
}
