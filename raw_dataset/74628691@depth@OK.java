public void depth(int node, int parent) {
    if (parent == -1)
        depth[node] = 0;
    else
        depth[node] = depth[parent] + 1;
    for (int i : G[node]) {
        if (i == parent)
            continue;
        depth(i, node);
    }
}