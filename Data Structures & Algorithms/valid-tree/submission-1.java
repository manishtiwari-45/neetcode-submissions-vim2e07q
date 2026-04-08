class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

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

        boolean[] visited = new boolean[n];

        if (DFS(graph, visited, 0, -1)) {
            return false; 
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent) {

        visited[node] = true;
        for (int v : adj.get(node)) {

            if (v == parent){
                continue;
            }
            if (visited[v]) {
                return true; 
            }

            if (DFS(adj, visited, v, node)) {
                return true;
            }
        }
        return false;
    }
}