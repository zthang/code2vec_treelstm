void solve() {
    // Type solution here.
    int n = s.nextInt();
    int k = s.nextInt();
    int[] parent = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 0;
    }
    int ans = 0;
    for (int i = 0; i < k; i++) {
        int u = s.nextInt();
        u--;
        int v = s.nextInt();
        v--;
        int pu = getparent(u, parent);
        int pv = getparent(v, parent);
        if (pu == pv)
            ans++;
        else
            union(pu, pv, parent, rank);
    }
    System.out.println(ans);
}