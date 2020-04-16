private static boolean dfs(int u, int t, List<List<Integer>> links, int[] cnt) {
    cnt[u] = 1;
    boolean flag = u == t;
    for (int v : links.get(u)) {
        if (cnt[v] == 0) {
            flag = dfs(v, t, links, cnt) || flag;
            cnt[u] += cnt[v];
        }
    }
    return flag;
}