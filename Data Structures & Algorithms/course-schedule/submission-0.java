class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int course = edge[0];
            int preq = edge[1];
            adj.get(preq).add(course);
            in[course]++;
        }
        
        return topologicalSortCheck(adj, numCourses, in);
    }
    private boolean topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] in){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(in[i]== 0){
                count++;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(int v : adj.get(u)){
                in[v]--;
                if(in[v] == 0){
                    count++;
                    queue.offer(v);
                }
            }
        }
        return count == n;
    }
}