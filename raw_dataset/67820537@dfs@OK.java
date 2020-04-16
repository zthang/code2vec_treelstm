static void dfs(int a) {
    if (visited[a])
        return;
    visited[a] = true;
    for (int c : set[a]) {
        if (!used[c]) {
            used[c] = true;
            for (int x : arr[c]) if (!visited[x])
                dfs(x);
        }
    }
}