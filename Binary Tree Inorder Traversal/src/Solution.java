import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> data = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root!=null){
            data.push(root);
            TreeNode target = root.left;
            while(data.empty()==false||target!=null){
                if(target!=null){
                    data.push(target);
                    target = target.left;
                }
                else{
                    TreeNode output = data.pop();
                    result.add(output.val);
                    target = output.right;
                }
            }
        }
        return result;
    }

}
