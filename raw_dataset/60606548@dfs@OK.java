private static void dfs(int u, int[] color, int[] visited, ArrayList<ArrayList<Integer>> g, HashMap<Integer, HashMap<Integer, Integer>> map) {
    visited[u] = 1;
    for (int nbr : g.get(u)) {
        int idx = map.get(u).get(nbr);
        if (visited[nbr] == 0) {
            dfs(nbr, color, visited, g, map);
        } else if (visited[nbr] == 1) {
            color[idx] = 2;
        }
    }
    visited[u] = 2;
}