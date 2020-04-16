static void dfs(int a) {
    if (visited[a])
        return;
    visited[a] = true;
    for (int c : arr[a]) dfs(c);
    length++;
    return;
}