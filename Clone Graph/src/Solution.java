import java.util.*;
class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DFS and avoid circle
    
    private HashMap<Integer,UndirectedGraphNode> path = new HashMap<Integer,UndirectedGraphNode>();
    //Remeber the path we passed by to avoid circle
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        else{
            UndirectedGraphNode n = new UndirectedGraphNode(node.label);
            return circle(n, node);
        }
    }
    
    private UndirectedGraphNode circle(UndirectedGraphNode n, UndirectedGraphNode node){
        if(path.containsKey(node.label)){
            return path.get(node.label);
        }
        else{
            path.put(node.label,n);
            for(UndirectedGraphNode x : node.neighbors){
                n.neighbors.add(circle(new UndirectedGraphNode(x.label), x));
            }
            return n;
        }
    }
}
