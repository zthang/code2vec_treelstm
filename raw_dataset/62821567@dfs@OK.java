void dfs(int u, int p) {
    stack[top++] = u;
    for (int i = 0; i < adj[u].size(); i++) {
        int v = adj[u].get(i);
        if (v != p) {
            if (visited[v]) {
                if (cycle[v] > 0)
                    continue;
                int index = top - 1;
                while (true) {
                    int w = stack[index--];
                    cycle[w] = cmp;
                    if (w == v)
                        break;
                }
                cmp++;
            } else {
                visited[v] = true;
                dfs(v, u);
            }
        }
    }
    top--;
}