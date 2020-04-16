public void dfs1(int node) {
    if (visited[node])
        return;
    visited[node] = true;
    LOL[node] = true;
    for (int[] i : G[node]) {
        if (visited[i[0]]) {
            if (LOL[i[0]])
                ans[i[1]] = 2;
            else
                ans[i[1]] = 1;
            continue;
        }
        ans[i[1]] = 1;
        dfs1(i[0]);
    }
    LOL[node] = false;
}