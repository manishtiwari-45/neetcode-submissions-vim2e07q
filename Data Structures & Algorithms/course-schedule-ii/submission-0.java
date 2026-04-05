class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        
        return topologicalSort(adj, numCourses, in, result);
        
    }

    private int[] topologicalSort(Map<Integer, List<Integer>> adj, int n, int[] in, int[] result){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        
        int j = 0;
        for(int i = 0; i < n; i++){
            if(in[i]== 0){
                count++;
                queue.offer(i);
                result[j] = i;
                j++;
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(int v : adj.get(u)){
                in[v]--;
                if(in[v] == 0){
                    count++;
                    queue.offer(v);
                    result[j] = v;
                    j++;
                }
            }
        }
        if(count == n){
            return result;
        }
        else{
            return new int[0];
        }
    }
}