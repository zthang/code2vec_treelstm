public void dfs(int node) {
    if (loop)
        return;
    visited[node] = true;
    LOL[node] = true;
    for (int[] i : G[node]) {
        if (visited[i[0]]) {
            if (LOL[i[0]])
                loop = true;
            continue;
        }
        dfs(i[0]);
    }
    LOL[node] = false;
}