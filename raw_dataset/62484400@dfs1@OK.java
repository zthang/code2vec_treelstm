public void dfs1(int node, int parent, int which) {
    answer[node] = which / 2 + 1;
    for (int i : G[node]) {
        if (i == parent)
            continue;
        dfs1(i, node, map[which]);
    }
}