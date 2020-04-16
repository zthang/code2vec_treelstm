public void dfs(int node, int parent) {
    if (visited[node])
        return;
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
        dfs(i[0], node);
    }
    LOL[node] = false;
}