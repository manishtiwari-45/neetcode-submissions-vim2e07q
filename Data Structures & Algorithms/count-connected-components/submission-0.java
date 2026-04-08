class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add (v);
            graph.get(v).add(u);
        }
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                DFS(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    public void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
            visited[node] = true;
            
            for(int v : adj.get(node)){
                if(!visited[v]){
                    DFS(adj,visited,v);
                }
            }
    }
}
