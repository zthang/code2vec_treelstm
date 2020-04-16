void dfs(boolean[] visited, int start) {
    visited[start] = true;
    fa[ind] = start;
    ind++;
    for (int i = 0; i < arr[start].size(); i++) {
        if (visited[arr[start].get(i)] == false)
            dfs(visited, arr[start].get(i));
    }
}