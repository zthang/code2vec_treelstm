public void dfs(int root, int[] cnt, int forbiden) {
    if (visited[root] || root == forbiden) {
        return;
    }
    visited[root] = true;
    cnt[root]++;
    for (IntIterator iterator = edges.iterator(root); iterator.hasNext(); ) {
        int node = iterator.next();
        dfs(node, cnt, forbiden);
    }
}