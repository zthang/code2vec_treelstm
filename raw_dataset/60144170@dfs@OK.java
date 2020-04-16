static void dfs(int a) {
    visited[a] = true;
    stack[a] = true;
    for (DColoringEdges.Pair p : graph[a].edges) {
        if (!visited[p.x]) {
            ans[p.y] = 1;
            dfs(p.x);
        } else {
            if (stack[p.x]) {
                ans[p.y] = 2;
            } else {
                ans[p.y] = 1;
            }
        }
    }
    stack[a] = false;
}