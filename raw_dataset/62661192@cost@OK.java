static long cost(int v, int l, int[] arr, boolean[] vis, int[] col) {
    vis[v] = true;
    col[v] = arr[l] + 1;
    Iterator<Integer> itr = adj[v].listIterator();
    while (itr.hasNext()) {
        int n = itr.next();
        if (!vis[n]) {
            return c[arr[(l + 1) % 3]][n] + cost(n, (l + 1) % 3, arr, vis, col);
        }
    }
    return 0;
}