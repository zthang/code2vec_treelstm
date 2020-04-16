public static void go(int i) {
    if (adj[i].size() == 1) {
        marked[i] = true;
        cnt++;
        int x = adj[i].first();
        adj[i].remove(x);
        adj[x].remove(i);
        go(x);
    }
}