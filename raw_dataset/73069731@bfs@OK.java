public static void bfs() {
    boolean[] vis = new boolean[n];
    Queue<Integer> qu = new LinkedList<>();
    vis[0] = true;
    qu.add(0);
    while (!qu.isEmpty()) {
        int u = qu.poll();
        for (int i = 0; i < adjList[u].size(); i++) {
            int v = adjList[u].get(i);
            if (!vis[v]) {
                if (rootCheck[u].get(i)) {
                    score[v] = Math.max(score[v], score[u]);
                } else {
                    score[v] = Math.max(score[v], score[u] + score[v]);
                }
                vis[v] = true;
                qu.add(v);
            }
        }
    }
}