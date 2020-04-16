public int dfs(int node, int parent) {
    int size = 0;
    for (int[] i : G[node]) {
        if (i[0] == parent)
            continue;
        int sz = dfs(i[0], node);
        size += sz;
        if (sz % 2 == 1)
            min += i[1];
        max += (Math.min(sz + 0l, n - sz + 0l) * i[1]);
    }
    return size + 1;
}