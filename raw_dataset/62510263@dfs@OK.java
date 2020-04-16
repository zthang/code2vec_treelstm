public static void dfs(int current, int parent) {
    for (Integer x : adj[current]) {
        if (x != parent) {
            dfs(x, current);
        }
    }
    if (adj[current].size() == 2) {
        deg2++;
    } else if (adj[current].size() == 1) {
        deg1++;
        if (firstdeg1 == -1) {
            firstdeg1 = current;
        }
    }
}