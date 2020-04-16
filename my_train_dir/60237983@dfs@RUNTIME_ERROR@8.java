    private static void dfs(int u) {
        col[u] = 1;

        for (int[] p : graph[u]) {
            int to = p[0];
            int id = p[1];

            if(col[to] == 0) {
                dfs(to);
                res[id] = 1;
            }

            if(col[to] == 2) {
                res[id] = 1;
            }
            else{
                res[id] = 2;
                isCycle = true;
            }
        }
        col[u] = 2;
    }