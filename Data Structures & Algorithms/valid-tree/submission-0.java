class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        if(!dfs(graph, visited, 0, -1)){
            return false;
        }
        for(boolean v : visited){
            if(v == false){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent){
        if(visited[node] == true){
            return false;
        }
        visited[node] = true;
        for(int neigh : graph.get(node)){
            if(neigh == parent){
                continue;
            }
            if(!dfs(graph, visited, neigh, node)){
                return false;
            }
        }
        return true;
    }
}
