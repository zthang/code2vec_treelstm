public static int recursion(int node) {
    int ans = color[node];
    for (int child : tree[node]) {
        if (!vis[child]) {
            vis[child] = true;
            parent[child] = node;
            int a = recursion(child);
            if (a >= 0)
                ans += a;
        }
    }
    dp[node] = ans;
    return ans;
}