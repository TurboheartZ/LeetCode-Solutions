import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList<Integer>();
	}
    //Using Divide and Conquer
    //Using DP
    public static List<TreeNode> generateTrees(int n) {
        return generate(1,n+1);
    }
    private static List<TreeNode> generate(int begin, int end){
        List<TreeNode> tree = new ArrayList<TreeNode>();
        if(begin==end){
            return tree;
        }
        else if(begin==end-1){
            TreeNode node = new TreeNode(begin);
            tree.add(node);
            return tree;
        }
        else{
            for(int i = begin; i<end; i++){
                List<TreeNode> left = generate(begin,i);
                List<TreeNode> right = generate(i+1,end);
                if(left.size()>0&&right.size()>0){
                    for(int m = 0; m<left.size(); m++){
                        for(int n = 0; n<right.size(); n++){
                            TreeNode node = new TreeNode(i);
                            node.left = left.get(m);
                            node.right = right.get(n);
                            tree.add(node);
                        }
                    }                    
                }
                else if(left.size()==0){
                    for(int n = 0; n<right.size(); n++){
                        TreeNode node = new TreeNode(i);
                        node.left = null;
                        node.right = right.get(n);
                        tree.add(node);
                    }                    
                }
                else if(right.size()==0){
                    for(int m = 0; m<left.size(); m++){
                        TreeNode node = new TreeNode(i);
                        node.right = null;
                        node.left = left.get(m);
                        tree.add(node);
                    }                    
                }
                else{
                    TreeNode node = new TreeNode(i);
                    tree.add(node);
                }
            }
            return tree;
        }
    }
}
