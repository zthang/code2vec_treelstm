public static void dfs2(ArrayList<ArrayList<Integer>> rgraph, boolean[] visited, int src, int[] sol, final int cnt) {
    visited[src] = true;
    sol[src] = cnt;
    for (int c : rgraph.get(src)) {
        if (visited[c])
            continue;
        sol[c] = cnt;
        dfs2(rgraph, visited, c, sol, cnt);
    }
}