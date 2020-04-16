public static void dfs(int x, int y) {
    // System.out.println(x+" "+y);
    visit[x] = 1;
    for (int v : adj[x]) {
        if ((v != y) && (visit[v] == 0))
            dfs(v, y);
    }
}