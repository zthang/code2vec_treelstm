public void solve() {
    int ans = 0;
    for (int i = 0; i < 26; i++) {
        if (!visit[i] && a[i]) {
            dfs(i);
            ans++;
        }
    }
    System.out.println(ans);
}