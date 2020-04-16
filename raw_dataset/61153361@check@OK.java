int check(String x) {
    HashSet<Pair> y = new HashSet<>(hs);
    int n = x.length();
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            int a = (int) x.charAt(i - 1) - '0';
            int b = (int) x.charAt(j - 1) - '0';
            if (adj[i].contains(j) && y.contains(new Pair(a, b))) {
                y.remove(new Pair(a, b));
                ans++;
            }
        }
    }
    return ans;
}