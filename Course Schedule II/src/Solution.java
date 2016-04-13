import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList<Integer>();
	}
	//****This is the version we donot consider duplicate (v,u) pairs
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if(numCourses<=0){
            return new int[0];
        }
        else{
            //Build the graph first
            //HashMap<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
            //****If we donot consider the situation that a specific (v,u) pair may appear more than once, we can use list rather than hash
            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            int[] indegree = new int[numCourses];
            for(int[] x : prerequisites){
                int first = x[0];
                int second = x[1];
                if(graph[second]==null){
                    graph[second] = new ArrayList<Integer>();
                }
                graph[second].add(first);
                indegree[first]++;
            }
            int[] result = new int[numCourses];
            int p = 0;
            //Use the Queue structure to check for cycles
            Queue<Integer> topoSort = new LinkedList<Integer>();
            for(int i = 0; i<numCourses; i++){
                if(indegree[i]==0){
                    topoSort.offer(i);
                }
            }
            while(topoSort.size()>0){
                int cNum = topoSort.poll();
                result[p++] = cNum;
                if(graph[cNum]!=null&&graph[cNum].size()>0){
                    for(int x : graph[cNum]){
                        indegree[x]--;
                        if(indegree[x]<0){
                            return new int[0];
                        }
                        else if(indegree[x]==0){
                            topoSort.offer(x);
                        }
                    }                    
                }
            }
            return p==numCourses?result:new int[0];
        }        
    }
	
	
	//****This is the version concerned about duplicate (u,v) pairs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<=0){
            return new int[0];
        }
        else{
            //Build the graph first
            HashMap<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
            //If we do not consider the situations that a specific (v,u) pair appear more than once,
            //We can use List rather than HashSet;
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
            int[] result = new int[numCourses];
            int p = 0;
            //Use the Queue structure to check for cycles
            Queue<Integer> topoSort = new LinkedList<Integer>();
            for(int i = 0; i<numCourses; i++){
                if(indegree[i]==0){
                    topoSort.offer(i);
                }
            }
            while(topoSort.size()>0){
                int cNum = topoSort.poll();
                result[p++] = cNum;
                if(graph.containsKey(cNum)){
                    for(int x : graph.get(cNum)){
                        indegree[x]--;
                        if(indegree[x]<0){
                            return new int[0];
                        }
                        else if(indegree[x]==0){
                            topoSort.offer(x);
                        }
                    }
                }
            }
            return p==numCourses?result:new int[0];
        }        
    }
}
