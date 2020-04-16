public void dfs(int s) {
    boolean[] visited = new boolean[V];
    Arrays.fill(visited, false);
    int x = dfsU(visited, s);
    ans[s] = val[s];
    Arrays.fill(visited, false);
    dfsUF(visited, s);
}