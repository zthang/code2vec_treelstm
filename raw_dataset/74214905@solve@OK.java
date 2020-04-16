public static void solve() {
    int t = s.nextInt();
    while (t-- > 0) {
        int n = s.nextInt();
        permutation = new int[n + 1];
        colors = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            permutation[i] = s.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            colors[i] = s.nextInt();
        }
        out.println(dfs_Util());
    }
}