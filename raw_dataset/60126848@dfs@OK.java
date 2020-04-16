public static void dfs(int i, boolean[] flag) {
    flag[i] = true;
    visited[i] = true;
    for (Node item : adj[i]) {
        if (flag[item.dest])
            item.color = 2;
        else
            item.color = 1;
        if (!visited[item.dest])
            dfs(item.dest, flag);
    }
    flag[i] = false;
}