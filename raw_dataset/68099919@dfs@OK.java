public static int dfs(int now, Vector<Vector<Integer>> g, int[] vis, int a, int b) {
    vis[now] = 1;
    tp++;
    int ans = 0;
    for (int i = 0; i < g.get(now).size(); i++) {
        int v = g.get(now).get(i);
        // System.out.println("u:"+now+" v:"+v);
        if (v == a) {
            ans |= 1;
        }
        if (v == b) {
            ans |= 2;
        }
        if (vis[v] == 0) {
            ans |= dfs(v, g, vis, a, b);
        }
    }
    return ans;
}