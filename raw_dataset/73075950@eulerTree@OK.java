public static void eulerTree(int node) {
    vis[node] = true;
    euler[index] = node;
    index++;
    for (int child : tree[node]) {
        if (!vis[child]) {
            eulerTree(child);
            euler[index] = node;
            index++;
        }
    }
}