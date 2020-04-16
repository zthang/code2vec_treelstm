void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    adj = new List[n];
    vis = new boolean[n];
    comps = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
        vis[i] = false;
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            comps.add(flood(i));
        }
    }
    comps.sort(Comparator.comparing(Pair<Integer, Integer>::getKey).thenComparing(Pair::getValue));
    int maks = -1;
    int answer = 0;
    for (Pair<Integer, Integer> p : comps) {
        if (p.getKey() < maks) {
            answer++;
        }
        maks = Math.max(maks, p.getValue());
    }
    out.println(answer);
}