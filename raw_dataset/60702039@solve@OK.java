void solve(int n, int k) throws IOException {
    for (int i = 1; i <= k; i++) {
        int a, b;
        a = Read.nextInt();
        b = Read.nextInt();
        addEdge(a, b);
        addEdge(b, a);
    }
    ans = k;
    for (int i = 1; i <= n; i++) {
        dfs(i);
    }
    System.out.println(ans);
}