import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //This problem is supposed to be solved via Topological Sort to check if circle exits
    //However, can we use Union-Find method to solve it?--->No! Coz union-find can not be used for directed graph
    //Let us do Topological Sort first
	//If we use adjacent lists to denote adjacent vertices, it takes O(V+E)
	//If we use Matrix to denote adjacent vertices, it takes O(V^2)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0){
            return false;
        }
        else{
            if(prerequisites.length==0){
                return true;
            }
            else{
                //Build the graph first
                HashMap<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
                int[] indegree = new int[numCourses];
                for(int[] x : prerequisites){
                    int first = x[0];
                    int second = x[1];
                    if(graph.containsKey(second)==true){
                        HashSet<Integer> hs = graph.get(second);
                        if(hs.add(first)==true){
                            indegree[first]++;
                        }
                        graph.replace(second,hs);
                    }
                    else{
                        HashSet<Integer> hs = new HashSet<Integer>();
                        hs.add(first);
                        indegree[first]++;
                        graph.put(second,hs);
                    }
                }
                Queue<Integer> topoSort = new LinkedList<Integer>();
                for(int i = 0; i<numCourses; i++){
                    if(indegree[i]==0){
                        topoSort.offer(i);
                    }
                }
                if(topoSort.size()==0){
                    return false;
                }
                else{
                    int count = 0;
                    while(topoSort.size()>0){
                        int cNum = topoSort.poll();
                        count++;
                        if(graph.containsKey(cNum)){
                            for(int x : graph.get(cNum)){
                                indegree[x]--;
                                if(indegree[x]<0){
                                    return false;
                                }
                                else if(indegree[x]==0){
                                    topoSort.offer(x);
                                }
                            }
                        }
                    }
                    return count==numCourses;
                }
            }
        }
    }
}
