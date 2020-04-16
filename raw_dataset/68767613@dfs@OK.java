static void dfs(int root) {
    if (visited[root])
        return;
    temp3.add(root);
    visited[root] = true;
    for (int c : arr[root]) dfs(c);
    return;
}